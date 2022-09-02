package edu.pe.pucp.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityTresEnRayaEstadisticas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tres_en_raya_estadisticas);

        Intent intent = getIntent();
        String estadisticasStr= "";

        ArrayList<Integer> est = (ArrayList<Integer>) intent.getSerializableExtra("estadisticas");

        for(Integer i : est){
            switch(i){
                case -3:
                    estadisticasStr+="Empate\n";
                    break;
                case -2:
                    estadisticasStr+="Ganó X\n";
                    break;
                case -1:
                    estadisticasStr+="Gano O\n";
                    break;
                case -4:
                    estadisticasStr+="Cancelado\n";
                    break;
            }
        }

        ((TextView) findViewById(R.id.showEstadisticas)).setText(estadisticasStr);

    }
}