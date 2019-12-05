package service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import entity.Company;
import factory.NodeCallFactory;
import retrofit2.Response;

public class NodeServiceImpl implements NodeService{
    @Override
    public List<Company> getSuppotrTicketCompanies() {
        List<Company> suppotrTicketCompanies = new ArrayList<Company>();
        try {
            Response<JsonObject> response= NodeCallFactory.getNodeCall().getSupportCompaniesCall().execute();
            suppotrTicketCompanies= extractCompanyListInResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suppotrTicketCompanies;
    }
    private List<Company> extractCompanyListInResponse( Response<JsonObject> response){
        List<Company> suppotrTicketCompanies = new ArrayList<Company>();
        try {
            JsonArray companiesJsonArray = response.body().getAsJsonArray("entity");
            Type type = new TypeToken<List<Company>>(){}.getType();
            Gson gson = new Gson();
            suppotrTicketCompanies = gson.fromJson(companiesJsonArray.toString(), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suppotrTicketCompanies;
    }



  /*  @Override
    public List<Company> getSuppotrTicketCompanies() {
        List<Company> companyList = new ArrayList<Company>();
        try {
            HttpUrlConnectionMM.myCookie= SessionFactory.getSession().getSessionId();
            String response = HttpUrlConnectionMM.excuteGet("http://192.168.254.144:1881/support/ticket/companies");
            JSONObject responseJson = new JSONObject(response);
            JSONArray companiesJsonArray= responseJson.getJSONArray("entity");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Company>>(){}.getType();
            companyList = gson.fromJson(companiesJsonArray.toString(), type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return companyList;
    }*/
}
