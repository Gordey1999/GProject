package com.example.gproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    int minValue, maxValue, middleValue;

    TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionText = findViewById(R.id.textView);

        Intent intent = getIntent();
        minValue = intent.getIntExtra("min", 0);
        maxValue = intent.getIntExtra("max", 10);

        askQuestion();
    }

    public void askQuestion() {
        String question;
        if (minValue == maxValue) {
            question = String.format("Ваше число равно %d?", minValue);
        } else if (maxValue - minValue == 1) {
            question = String.format("Ваше число равно %d?", minValue);
        } else {
            middleValue = (minValue + maxValue) / 2;
            question = String.format("Ваше число мешьше %d?", middleValue);
        }

        questionText.setText(question);
    }

    public void onClickYes(View view) {
        if (minValue == maxValue || maxValue - minValue == 1) {
            String msg = "Я выиграл!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            finish();
        } else {
            maxValue = middleValue - 1;
            askQuestion();
        }
    }

    public void onClickNo(View view) {
        if (minValue == maxValue) {
            String msg = "Ты меня обманываешь!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            finish();
        } else if (maxValue - minValue == 1) {
            minValue = maxValue;
            askQuestion();
        } else {
            minValue = middleValue;
            askQuestion();
        }
    }
}
