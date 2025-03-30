package br.com.fecapccp.textinput;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Obesidade2Activity extends AppCompatActivity {

    private float peso;
    private float altura;
    private float IMC;
    private TextView textPeso;
    private TextView textAltura;
    private TextView textIMC;
    private Button btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);

        btnClose = findViewById(R.id.btnFechar);
        btnClose.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalculoIMCActivity.class);
            startActivity(intent);
            finish();
        });

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getFloat("peso");
        altura = bundle.getFloat("altura");
        IMC = bundle.getFloat("IMC");

        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);
        textIMC = findViewById(R.id.textIMC);

        String formatado = String.format(Locale.US, "%.2f", IMC);

        textPeso.setText("Peso(kg): "+ peso);
        textAltura.setText("Altura(m): "+ altura);
        textIMC.setText("IMC: "+ formatado);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

}