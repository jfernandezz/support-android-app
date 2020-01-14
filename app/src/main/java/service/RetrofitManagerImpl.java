package factory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.CurrentSupportEnvironment;

public class RetrofitManager {
    private Retrofit globalRetrofit;

    private CurrentSupportEnvironment currentSupportEnvironment = CurrentSupportEnvironmentFactory.getCurrentSupportEnvironment();

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


    public Retrofit reBuildDefaultRetrofit() {
        return globalRetrofit = reBuildRetrofit(supportCompaniesInterceptor);
    }

    public Retrofit reBuildRetrofit(Interceptor interceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder().addInterceptor(interceptor);
        globalRetrofit = new Retrofit.Builder().baseUrl(currentSupportEnvironment.getCurrentEnvironment().getUrlBase()).client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return globalRetrofit;
    }


    public Retrofit getGlobalRetrofit() {
        return globalRetrofit;
    }

    public void setGlobalRetrofit(Retrofit globalRetrofit) {
        this.globalRetrofit = globalRetrofit;
    }
}
