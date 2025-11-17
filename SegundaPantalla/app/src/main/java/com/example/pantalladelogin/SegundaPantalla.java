package com.example.pantalladelogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaPantalla extends AppCompatActivity {

    private Button bDesconectar;
    private TextView tvCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_pantalla);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvCorreo = findViewById(R.id.tvCorreo);
        bDesconectar = findViewById(R.id.bDesconectar);
        String correoRecibido = getIntent().getStringExtra("correo");
        tvCorreo.setText(correoRecibido);
        bDesconectar.setOnClickListener(v -> {
            Intent intent = new Intent(SegundaPantalla.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
