package com.example.apptips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int teste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb = findViewById(R.id.seekBar);
        TextView valorSeek = findViewById(R.id.textViewPctSeekBar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valorSeek.setText("" + i + "%");
                teste = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    public void calculaTip(View view){
        EditText valorDig = findViewById(R.id.editTextValorDigitado);
        TextView valorTot = findViewById(R.id.textViewValorTot);

        TextView calc10 = findViewById(R.id.textView10Calc);
        TextView calc15 = findViewById(R.id.textView15Calc);
        TextView calc20 = findViewById(R.id.textView20Calc);

        TextView tot10 = findViewById(R.id.textView10Total);
        TextView tot15 = findViewById(R.id.textView15Total);
        TextView tot20 = findViewById(R.id.textView20Total);

        Double resultado;
        Double digitado = Double.valueOf(valorDig.getText().toString());
        resultado = digitado * 0.1;
        calc10.setText(String.valueOf(resultado));
        tot10.setText(String.valueOf(resultado + digitado));

        resultado = digitado * 0.15;
        calc15.setText(String.valueOf(resultado));
        tot15.setText(String.valueOf(resultado + digitado));

        resultado = digitado * 0.2;
        calc20.setText(String.valueOf(resultado));
        tot20.setText(String.valueOf(resultado + digitado));

        resultado = teste/100.0;
        resultado = resultado*digitado;
        resultado = resultado + digitado;

        valorTot.setText(String.valueOf(resultado));

    }


}