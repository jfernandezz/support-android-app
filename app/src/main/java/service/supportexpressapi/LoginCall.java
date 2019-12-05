package service.supportexpressapi;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginCall {

    @FormUrlEncoded
    @POST("/login.html")
    Call<String> login(@Field(value="username",encoded = true) String username,@Field(value = "password",encoded = true)String password);



}
