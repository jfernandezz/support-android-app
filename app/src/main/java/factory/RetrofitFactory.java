package factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ConcurrentHashMap;

import Entity.SupportEnvironmentContainer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitFactory {
    SupportEnvironmentContainer currentEnvironmentService;
    ConcurrentHashMap<String, Retrofit> environmentRetrofitMap= new ConcurrentHashMap<String, Retrofit>();

    public Retrofit getRetrofit(OkHttpClient okHttpClient){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(currentEnvironmentService.getCurrentEnvironment().getUrlBase()/*"http://192.168.254.144:1881"*/)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }


}
