package brendatests.com.mobiletest.inputoutput;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class DatosApiAdapter {

    private static DatosApiService API_SERVICE;

    public static DatosApiService getApiService() {


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "https://randomuser.me/";
        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) //
                    .build();
            API_SERVICE = retrofit.create(DatosApiService.class);
        }

        return API_SERVICE;
    }

}
