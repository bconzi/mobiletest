package brendatests.com.mobiletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import brendatests.com.mobiletest.Model.Datos;
import brendatests.com.mobiletest.inputoutput.DatosApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static brendatests.com.mobiletest.inputoutput.DatosApiAdapter.getApiService;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Datos>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Call<ArrayList<Datos>> call= DatosApiAdapter.getApiService().getDatos();

       call.enqueue(this);


    }

    @Override
    public void onResponse(Call<ArrayList<Datos>> call, Response<ArrayList<Datos>> response) {
        if (response.isSuccessful()){
           ArrayList<Datos> datos= response.body();
            Log.d("onResponse datos", "Size of datos => "+datos.size());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Datos>> call, Throwable t) {

    }
}
