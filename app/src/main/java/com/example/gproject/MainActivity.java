package com.example.gproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editTextMin, editTextMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
    }

    public void onClick(View view) {

        String strMin = editTextMin.getText().toString();
        String strMax = editTextMax.getText().toString();

        if (strMin.isEmpty() || strMax.isEmpty()) {
            String msg = "Заполните значения";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return;
        }

        int min = Integer.parseInt(strMin);
        int max = Integer.parseInt(strMax);

        if (min > max) {
            String msg = "Неверный диапазон";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("min", min);
        intent.putExtra("max", max);
        startActivity(intent);
    }
}
