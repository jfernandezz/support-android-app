package service.supportexpressapi;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;


public interface NodeCall {
    @GET("/support/ticket/companies")
    Call<JsonObject> getSupportCompaniesCall();
}
