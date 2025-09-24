package com.example.appcourrier;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // tu layout con header + bottomNav

        bottomNav = findViewById(R.id.bottomNav);

        // 👇 Siempre marcar Home cuando entras a esta pantalla
        bottomNav.setSelectedItemId(R.id.nav_home);

        findViewById(R.id.btnCompras).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ComprasActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btnEnvios).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EnviosActivity.class);
            startActivity(intent);
        });


        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Ya estás en Home, no hacer nada
                    return true;
                }

                if (id == R.id.nav_add) {
                    // Abrir NuevaCompraActivity
                    Intent intent = new Intent(MainActivity.this, nuevaCompraActivity.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}
