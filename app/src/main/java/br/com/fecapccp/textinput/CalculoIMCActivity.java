package br.com.fecapccp.textinput;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import java.text.DecimalFormat;

public class CalculoIMCActivity extends AppCompatActivity {

    private Button btnSet;
    private EditText editTextPeso;
    private EditText editTextAltura;
    private float peso;
    private float altura;
    private float IMC;
    private Button btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imc);

        editTextPeso = findViewById(R.id.editPeso);
        editTextAltura = findViewById(R.id.editAltura);

        DecimalFormat df = new DecimalFormat("0.00");

        btnSet = findViewById(R.id.btnCalcular);
        btnSet.setOnClickListener(view -> {
            peso = Float.parseFloat(editTextPeso.getText().toString());
            altura = Float.parseFloat(editTextAltura.getText().toString());
            IMC = peso/((altura)*(altura));

            Class activity = MainActivity.class;

            if(IMC<18.5){
                activity = AbaixoDoPesoActivity.class;
            }
            else if(IMC>=18.5 && IMC<25){
                activity = PesoNormalActivity.class;
            }
            else if(IMC>=25 && IMC<30){
                activity = SobrepesoActivity.class;
            }
            else if(IMC>=30 && IMC<35){
                activity = Obesidade1Activity.class;
            }
            else if(IMC>=35 && IMC<40){
                activity = Obesidade2Activity.class;
            }
            else if(IMC>=40){
                activity = Obesidade3Activity.class;
            }

            Intent intent = new Intent(this, activity);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("IMC", IMC);

            startActivity(intent);
        });

            btnClose = findViewById(R.id.btnFechar);
            btnClose.setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            });


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

        public void Limpar(View view){
            editTextPeso = findViewById(R.id.editPeso);
            editTextAltura = findViewById(R.id.editAltura);

            editTextPeso.setText("");
            editTextAltura.setText("");
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