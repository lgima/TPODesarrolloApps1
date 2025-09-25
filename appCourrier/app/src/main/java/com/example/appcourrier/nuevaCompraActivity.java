package com.example.appcourrier;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class nuevaCompraActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_compra);

        bottomNav = findViewById(R.id.bottomNav);

        //  marcar + cuando estas en esa pantalla
        bottomNav.setSelectedItemId(R.id.nav_add);

        findViewById(R.id.btnCancelarnuevaCompra).setOnClickListener(v -> {
            Intent intent = new Intent(nuevaCompraActivity.this, MainActivity.class);
            startActivity(intent);
        });

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_add) {
                    return true;
                }

                if (id == R.id.nav_home) {
                    Intent intent = new Intent(nuevaCompraActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                    return true;
                }
                if (id == R.id.nav_profile) {
                    Intent intent = new Intent(nuevaCompraActivity.this, Perfil_Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                    return true;
                }

                return false;
            }
        });
    }
}
