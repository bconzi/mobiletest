package brendatests.com.mobiletest.userinterface.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import brendatests.com.mobiletest.Model.RandomUser;
import brendatests.com.mobiletest.R;

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.ViewHolder> {
    private List<RandomUser> mDataSet;

    public RandomUser getItem(int position) {
        return mDataSet.get(position);
    }

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView txtVname;
        public ImageView ivPhotos;


        public ViewHolder(View v) {
            super(v);
            txtVname = (TextView) v.findViewById(R.id.txtname);
            ivPhotos= (ImageView)v.findViewById(R.id.fotos);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public RandomUserAdapter() {


    mDataSet= new ArrayList<>();
    }

    public void setDataset (List<RandomUser> dataset){

        mDataSet= dataset;

        notifyDataSetChanged();

    }
    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public RandomUserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {

        View v = (LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photos_view, parent, false));

       return new ViewHolder(v);
    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
           holder.txtVname.setText(mDataSet.get(i).getName().getFirst());

        Picasso.get().load(mDataSet.get(i).getPicture().getThumbnail()).into(holder.ivPhotos);

        ;
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo en RecyclerViews que implementar filtros o búsquedas
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
