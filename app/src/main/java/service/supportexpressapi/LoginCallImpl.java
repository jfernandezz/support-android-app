package service.supportexpressapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.JavaNetCookieJar;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class LoginCallImpl implements LoginCall {
    private Retrofit retrofit;
    public LoginCallImpl() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        okHttpClient.cookieJar(new JavaNetCookieJar(cookieManager));
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("content-type", "application/x-www-form-urlencoded")
                        .header("Accept","*/*")//.method("POST",body)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.254.144:1881")
                .client(okHttpClient.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Override
    public Call<String> login( String username, String password) {

        LoginCall loginCall = retrofit.create(LoginCall.class);

        return  loginCall.login(username,password);
    }
}
