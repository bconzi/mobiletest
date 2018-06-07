package brendatests.com.mobiletest.inputoutput;

import java.util.ArrayList;

import brendatests.com.mobiletest.Model.Datos;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DatosApiService {

    @GET("?results=5000")
    Call<ArrayList<Datos>> getDatos();


}
