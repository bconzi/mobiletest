package brendatests.com.mobiletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import brendatests.com.mobiletest.Model.Datos;
import brendatests.com.mobiletest.inputoutput.DatosApiAdapter;
import brendatests.com.mobiletest.userinterface.adapter.DatosAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static brendatests.com.mobiletest.inputoutput.DatosApiAdapter.getApiService;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Datos>> {

    private DatosAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configurar el RecyclerView

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDatos);

        mRecyclerView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Asocio el Recycler View con un adapter- Define cómo se va a renderizar la info que tengo
        mAdapter = new DatosAdapter();
        mRecyclerView.setAdapter(mAdapter);


        //Llamar al ApiService
        Call<ArrayList<Datos>> call= DatosApiAdapter.getApiService().getDatos();

        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<ArrayList<Datos>> call, Response<ArrayList<Datos>> response) {
        if (response.isSuccessful()){
            ArrayList<Datos> datos= response.body();
            Log.d("onResponse datos", "Size of datos => "+datos.size());

            mAdapter.setDataset(datos);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Datos>> call, Throwable t) {

    }
    }

