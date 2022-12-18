package com.example.farukov_pr_26;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
    }
    public void Click(View view) {
        if((radioButton1.isChecked() || radioButton3.isChecked()) && (radioButton2.isChecked() || radioButton4.isChecked())){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            if(radioButton1.isChecked()){
                intent.putExtra("drink", "coffee");
            }
            else if (radioButton3.isChecked()){
                intent.putExtra("drink", "tea");
            }
            if(radioButton2.isChecked()){
                intent.putExtra("food", "sweet");
            }
            else if (radioButton4.isChecked()){
                intent.putExtra("food", "combo");
            }
            startActivity(intent);
        }
    }
    public void ClickImage1(View view) {
        if(radioButton1.isChecked()){
            radioButton1.setChecked(false);
        }
        else{
            radioButton1.setChecked(true);
            if(radioButton3.isChecked()){
                radioButton3.setChecked(false);
            }
        }
    }
    public void ClickImage2(View view) {
        if(radioButton2.isChecked()){
            radioButton2.setChecked(false);
        }
        else{
            radioButton2.setChecked(true);
            if(radioButton4.isChecked()){
                radioButton4.setChecked(false);
            }
        }
    }
    public void ClickImage3(View view) {
        if(radioButton3.isChecked()){
            radioButton3.setChecked(false);
        }
        else{
            radioButton3.setChecked(true);
            if(radioButton1.isChecked()){
                radioButton1.setChecked(false);
            }
        }
    }
    public void ClickImage4(View view) {
        if(radioButton4.isChecked()){
            radioButton4.setChecked(false);
        }
        else{
            radioButton4.setChecked(true);
            if(radioButton2.isChecked()){
                radioButton2.setChecked(false);
            }
        }
    }
}