package edu.pe.pucp.lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityTresEnRayaGame extends AppCompatActivity {

    private int turno = 0;
    private boolean termino = false;

    static int EMPATE = -3;
    static int GANOX = -2;
    static int GANOO = -1;
    static int CANCELADO= -4;
    private ArrayList<Integer> estadisticas = new ArrayList<>();

    private Button[][] botones = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_tres_en_raya_game);
        
        botones[0][0] = (Button) findViewById(R.id.tres11);
        botones[0][1] = (Button) findViewById(R.id.tres12);
        botones[0][2] = (Button) findViewById(R.id.tres13);
        botones[1][0] = (Button) findViewById(R.id.tres21);
        botones[1][1] = (Button) findViewById(R.id.tres22);
        botones[1][2] = (Button) findViewById(R.id.tres23);
        botones[2][0] = (Button) findViewById(R.id.tres31);
        botones[2][1] = (Button) findViewById(R.id.tres32);
        botones[2][2] = (Button) findViewById(R.id.tres33);
    }


    public boolean checkWin() {

        String ev = botones[0][0].getText().toString();
        boolean row1 = !ev.equals("-") &&
                ev.equals(botones[0][1].getText().toString()) &&
                ev.equals(botones[0][2].getText().toString());
        if(row1){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }
            return true;
        }



        ev = botones[1][0].getText().toString();
        boolean row2 = !ev.equals("-") &&
                ev.equals(botones[1][1].getText().toString()) &&
                ev.equals(botones[1][2].getText().toString());
        if(row2){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }
        ev = botones[2][0].getText().toString();
        boolean row3 = !ev.equals("-") &&
                ev.equals(botones[2][1].getText().toString()) &&
                ev.equals(botones[2][2].getText().toString());
        if(row3){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }

        ev = botones[0][0].getText().toString();
        boolean col1 = !ev.equals("-") &&
                ev.equals(botones[1][0].getText().toString()) &&
                ev.equals(botones[2][0].getText().toString());
        if(col1){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }

        ev = botones[0][1].getText().toString();
        boolean col2 = !ev.equals("-") &&
                ev.equals(botones[1][1].getText().toString()) &&
                ev.equals(botones[2][1].getText().toString());
        if(col2){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }

        ev = botones[0][2].getText().toString();
        boolean col3 = !ev.equals("-") &&
                ev.equals(botones[1][2].getText().toString()) &&
                ev.equals(botones[2][2].getText().toString());
        if(col3){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }

        ev = botones[0][0].getText().toString();
        boolean diag1 = !ev.equals("-") &&
                ev.equals(botones[1][1].getText().toString()) &&
                ev.equals(botones[2][2].getText().toString());
        if(diag1){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }

        ev = botones[2][0].getText().toString();
        boolean diag2 = !ev.equals("-") &&
                ev.equals(botones[1][1].getText().toString()) &&
                ev.equals(botones[0][2].getText().toString());
        if(diag2){
            if(ev.equals("X")){
                estadisticas.add(GANOX);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó X");
            } else{
                estadisticas.add(GANOO);
                ((TextView) findViewById(R.id.textGanador)).setText("Ganó O");
            }

            return true;
        }

        return false;
    }

    public void play(View view) {


        Button button = (Button) view;
        if(termino || !button.getText().toString().equals("-")){
            return;
        }
        if (turno % 2 == 0) {
            button.setText("X");
        } else {
            button.setText("O");
        }

        if (turno > 3) {
            boolean win = checkWin();
            if(win){
                termino=true;
                return;
            }
            if (turno == 8 && !win) {
                termino = true;
                estadisticas.add(EMPATE);
                ((TextView) findViewById(R.id.textGanador)).setText("Empate");
            }
        }

        turno++;
    }

    public void newGame(View view) {
        if(turno==0){
            return;
        }
        turno=0;
        if(!termino){
            estadisticas.add(CANCELADO);
        }
        for(Button[] i : botones){
            for(Button j : i){
                j.setText("-");
            }
        }
        ((TextView) findViewById(R.id.textGanador)).setText("");
        termino = false;
    }

    public void showStatistics(View view) {
        Intent intent = new Intent(MainActivityTresEnRayaGame.this, MainActivityTresEnRayaEstadisticas.class);
        intent.putExtra("estadisticas", estadisticas);
        startActivity(intent);
    }
}