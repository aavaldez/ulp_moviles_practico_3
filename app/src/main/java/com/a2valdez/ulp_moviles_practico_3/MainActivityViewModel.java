package com.a2valdez.ulp_moviles_practico_3;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.a2valdez.ulp_moviles_practico_3.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private List<Inmueble> lista;
    private MutableLiveData<List<Inmueble>> mLista;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        lista = new ArrayList<>();
    }
    public LiveData<List<Inmueble>> getmLista() {
        if(mLista == null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }
    public void cargarPersonas(){
        lista.add(new Inmueble(R.drawable.casa1, "Calle 123", 2000));
        lista.add(new Inmueble(R.drawable.casa2, "Calle 123", 2000));
        lista.add(new Inmueble(R.drawable.casa3, "Calle 123", 2000));
        lista.add(new Inmueble(R.drawable.casa4, "Calle 123", 2000));
        lista.add(new Inmueble(R.drawable.casa5, "Calle 123", 2000));
        lista.add(new Inmueble(R.drawable.casa6, "Calle 123", 2000));
        lista.add(new Inmueble(R.drawable.casa7, "Calle 123", 2000));
        mLista.setValue(lista);
    }

}
