package brendatests.com.mobiletest.userinterface.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import brendatests.com.mobiletest.Model.Datos;
import brendatests.com.mobiletest.R;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolder> {
    private ArrayList <Datos> mDataSet;

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView textView;
        public ViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public DatosAdapter() {
    mDataSet= new ArrayList<>();
    }

    public void setDataset (ArrayList <Datos> dataset){

        mDataSet= dataset;

        notifyDataSetChanged();

    }
    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public DatosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.datos_view, parent, false);

       return new ViewHolder(tv);
    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
           holder.textView.setText(mDataSet.get(i).getName());
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo en RecyclerViews que implementar filtros o búsquedas
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
