package service.supportexpressapi;

import com.google.gson.JsonObject;

import java.io.IOException;

import factory.CurrentSupportEnvironmentFactory;
import factory.SessionFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.CurrentSupportEnvironment;

public class NodeCallImpl implements NodeCall {
    private Retrofit.Builder retrofitBuilder;
    private Retrofit retrofit;
    private CurrentSupportEnvironment currentSupportEnvironment = CurrentSupportEnvironmentFactory.getCurrentSupportEnvironment();

    public NodeCallImpl() {

        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder().addInterceptor(supportCompaniesInterceptor);
        retrofit = new Retrofit.Builder().baseUrl(currentSupportEnvironment.getCurrentEnvironment().getUrlBase()).client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public Call<JsonObject> getSupportCompaniesCall() {
        NodeCall nodeCall = retrofit.create(NodeCall.class);
        return nodeCall.getSupportCompaniesCall();
    }

    private String sessionId = SessionFactory.getSession().getSessionId();

    private Interceptor supportCompaniesInterceptor =
            new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Cookie", sessionId)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            };

}
