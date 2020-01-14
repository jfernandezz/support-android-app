package service;

import java.io.IOException;

import Entity.CurrentRetrofit;
import factory.CurrentRetrofitFactory;
import factory.CurrentSupportEnvironmentFactory;
import factory.SessionFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManagerImpl implements RetofitManager{
    private CurrentRetrofit currentRetrofit = CurrentRetrofitFactory.getCurrentRetrofit();

    public RetrofitManagerImpl() {
        reBuildDefaultRetrofit();
    }

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
        return reBuildRetrofit(supportCompaniesInterceptor);
    }

    public Retrofit reBuildRetrofit(Interceptor interceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder().addInterceptor(interceptor);
        Retrofit newRetrofit = new Retrofit.Builder().baseUrl(currentSupportEnvironment.getCurrentEnvironment().getUrlBase()).client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        currentRetrofit.setCurrentRetrofit(newRetrofit);
        return newRetrofit;
    }


}
