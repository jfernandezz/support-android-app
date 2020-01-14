package Entity;

import retrofit2.Retrofit;

public class CurrentRetrofit {
  private Retrofit currentRetrofit;

    public Retrofit getCurrentRetrofit() {
        return currentRetrofit;
    }

    public void setCurrentRetrofit(Retrofit currentRetrofit) {
        this.currentRetrofit = currentRetrofit;
    }
}
