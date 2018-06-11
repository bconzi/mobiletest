package brendatests.com.mobiletest.inputoutput;

import java.util.ArrayList;

import brendatests.com.mobiletest.Model.Photos;
import brendatests.com.mobiletest.Model.RandomUser;
import brendatests.com.mobiletest.Model.RandomUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DatosApiService {


    @GET("api?noinfo")
    Call<RandomUserResponse> traerUsuarios(@Query("results") int results);
}
