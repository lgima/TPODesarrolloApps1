package com.example.appcourrier;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class EnviosActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envios); //
        bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_add) {
                    // Abrir NuevaCompraActivity
                    Intent intent = new Intent(EnviosActivity.this, nuevaCompraActivity.class);
                    startActivity(intent);
                    return true;
                }

                if (id == R.id.nav_home) {
                    // Volver a Home sin duplicar Activities
                    Intent intent = new Intent(EnviosActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish(); // opcional, para cerrar esta Activity
                    return true;
                }

                return false;
            }
        });
    }
}
