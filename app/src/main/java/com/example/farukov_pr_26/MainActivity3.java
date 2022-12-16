package com.example.farukov_pr_26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void ClickBack(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
    }
    public void ClickView(View view) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER, name TEXT, phone TEXT, UNIQUE(id))");


        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        TextView textViewOrders= findViewById(R.id.textViewOrders);
        textViewOrders.setText("");

        while(query.moveToNext()){
            String name = query.getString(1);
            String phone = query.getString(2);

            textViewOrders.append("\n" + " Name: " + name + " Phone: " + phone + "\n");

        }
        query.close();
        db.close();
    }
}