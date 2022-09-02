package edu.pe.pucp.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn_memoria)).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activity_mem.class);
            startActivity(intent);
        });


        ((Button) findViewById(R.id.btn_ter)).setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, activity_ter.class);
            startActivity(intent1);
        });
    }
}