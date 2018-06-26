package brendatests.com.mobiletest;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import brendatests.com.mobiletest.Model.Name;
import brendatests.com.mobiletest.Model.Picture;
import brendatests.com.mobiletest.Model.RandomUser;

public class DetailActivity extends AppCompatActivity {

    private RandomUser detalle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        detalle = getIntent().getParcelableExtra("Detalle");

        Toast.makeText(this, "email", Toast.LENGTH_SHORT).show();

        Picasso.get().load(detalle.getPicture().getThumbnail()).into((ImageView)findViewById(R.id.fotos));

        TextView txtnombre = (TextView) findViewById(R.id.textView3);
        txtnombre.setText(detalle.getName().getFirst()+ " "+detalle.getName().getLast());

        TextView txtemail = (TextView) findViewById(R.id.textView2);
        txtemail.setText(detalle.getEmail());




    }
}
