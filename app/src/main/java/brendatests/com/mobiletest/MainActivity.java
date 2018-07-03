package brendatests.com.mobiletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import brendatests.com.mobiletest.Model.RandomUser;
import brendatests.com.mobiletest.Model.RandomUserResponse;
import brendatests.com.mobiletest.inputoutput.DatosApiAdapter;
import brendatests.com.mobiletest.userinterface.RecyclerTouchListener;
import brendatests.com.mobiletest.userinterface.adapter.RandomUserAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RandomUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewPhotos);

        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new RandomUserAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                mRecyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, final int position) {

                RandomUser randomUser = ((RandomUserAdapter) mRecyclerView.getAdapter()).getItem(position);

                navigateToDetails(randomUser);

            }


            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Long press on position :" + position,
                        Toast.LENGTH_LONG).show();
            }
        }));

        //Llamar al ApiService

        Call<RandomUserResponse> call = DatosApiAdapter.getApiService().traerUsuarios(50);

        call.enqueue(new Callback<RandomUserResponse>() {
            @Override
            public void onResponse(Call<RandomUserResponse> call, Response<RandomUserResponse> response) {
                RandomUserResponse userResponse = response.body();

                ((RandomUserAdapter) mRecyclerView.getAdapter()).setDataset(userResponse.getRandomUsers());

            }

            @Override
            public void onFailure(Call<RandomUserResponse> call, Throwable t) {

            }
        });


    }

    private void navigateToDetails(RandomUser randomUser) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Detalle", randomUser);
        startActivity(intent);

    }


}

