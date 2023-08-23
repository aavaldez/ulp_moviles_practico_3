package com.a2valdez.ulp_moviles_practico_3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.a2valdez.ulp_moviles_practico_3.databinding.ActivityMainBinding;
import com.a2valdez.ulp_moviles_practico_3.modelo.Inmueble;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getmLista().observe(this, new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> personas) {
                InmuebleAdapter pa = new InmuebleAdapter(MainActivity.this, binding.lvListaInmuebles.getId(), personas, getLayoutInflater());
                binding.lvListaInmuebles.setAdapter(pa);
            }
        });
        mv.cargarPersonas();
    }
}