package com.example.appcourrier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class datosPerfilActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private Spinner spinnerDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_datos_activity); //
        bottomNav = findViewById(R.id.bottomNav);
        spinnerDeposito = findViewById(R.id.spinnerDeposito);

        setupSpinners();

        findViewById(R.id.btnCancelarPerfil).setOnClickListener(v -> {
            Intent intent = new Intent(datosPerfilActivity.this, Perfil_Activity.class);
            startActivity(intent);
        });

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_add) {
                    Intent intent = new Intent(datosPerfilActivity.this, nuevaCompraActivity.class);
                    startActivity(intent);
                    return true;
                }

                if (id == R.id.nav_home) {
                    Intent intent = new Intent(datosPerfilActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                    return true;
                }
                if (id == R.id.nav_profile) {
                    Intent intent = new Intent(datosPerfilActivity.this, Perfil_Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                    return true;
                }

                return false;
            }
        });
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> adapterDeposito = ArrayAdapter.createFromResource(this,
                R.array.depositos_array, android.R.layout.simple_spinner_item);
        adapterDeposito.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDeposito.setAdapter(adapterDeposito);


    }
}