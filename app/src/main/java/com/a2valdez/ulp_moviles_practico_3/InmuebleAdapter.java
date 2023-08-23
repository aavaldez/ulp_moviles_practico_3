package com.a2valdez.ulp_moviles_practico_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.a2valdez.ulp_moviles_practico_3.modelo.Inmueble;

import java.util.List;

public class InmuebleAdapter extends ArrayAdapter<Inmueble> {
    private Context contexto;
    private List<Inmueble> lista;
    private LayoutInflater inflador;

    public InmuebleAdapter(@NonNull Context context, int resource, List<Inmueble> listado, LayoutInflater li) {
        super(context, resource, listado);
        this.contexto = context;
        this.lista = listado;
        this.inflador = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null){
            itemView = inflador.inflate(R.layout.item, parent, false);
        }
        Inmueble i = lista.get(position);
        TextView tvDireccion = itemView.findViewById(R.id.tvDireccion);
        TextView tvPrecio = itemView.findViewById(R.id.tvPrecio);
        ImageView imgFoto = itemView.findViewById(R.id.imgFoto);
        tvDireccion.setText(i.getDireccion());
        tvPrecio.setText(String.format("%2.0f", i.getPrecio()));
        imgFoto.setImageResource(i.getFoto());
        return itemView;
    }
    @Override
    public int getCount() {
        return lista.size();
    }
}
