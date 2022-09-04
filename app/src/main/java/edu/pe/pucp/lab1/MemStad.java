package edu.pe.pucp.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MemStad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_stad);
        ArrayList<Float> est = (ArrayList<Float>) getIntent().getSerializableExtra("est");
        String estString = "";
        if(!est.isEmpty()) {
            for (Float i : est) {
                if (i == 0) {
                    estString += "Cancelado\n";
                } else {
                    estString += "Termino en " + i + " minutos\n";
                }
            }
            ((TextView) findViewById(R.id.showEstadisticas)).setText(estString);
        }
    }

    public void back(View view){
        finish();
    }
}