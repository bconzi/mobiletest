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


    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.txtVname.setText(mDataSet.get(i).getName().getFirst());

        Picasso.get().load(mDataSet.get(i).getPicture().getThumbnail()).into(holder.ivPhotos);

        ;
    }


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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtVname;
        public ImageView ivPhotos;


        public ViewHolder(View v) {
            super(v);
            txtVname = (TextView) v.findViewById(R.id.txtname);
            ivPhotos = (ImageView) v.findViewById(R.id.fotos);
        }
    }

    // Método que define la cantidad de elementos del RecyclerView

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
