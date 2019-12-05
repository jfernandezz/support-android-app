package service.supportexpressapi;

import com.google.gson.JsonObject;

import java.io.IOException;

import factory.SessionFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NodeCallImpl implements NodeCall{
   private Retrofit retrofit;
   public NodeCallImpl() {
       OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();

       okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Cookie", SessionFactory.getSession().getSessionId())
                        .header("Content-Type" ,"application/json")
                        .header("Accept","*/*")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.254.144:1881").client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public Call<JsonObject> getSupportCompaniesCall() {
        NodeCall nodeCall = retrofit.create(NodeCall.class);
        return nodeCall.getSupportCompaniesCall();
    }
}
