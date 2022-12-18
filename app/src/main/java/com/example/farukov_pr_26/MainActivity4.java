package com.example.farukov_pr_26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void ClickBack(View view) {
        Intent intent = new Intent(MainActivity4.this, MainActivity.class);
        startActivity(intent);
    }
    public void ClickView(View view) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER, name TEXT, phone TEXT, drinkTitle TEXT, drinkCount INTEGER, foodTitle TEXT, foodCount INTEGER, UNIQUE(id))");

        Cursor query = db.rawQuery("SELECT * FROM orders;", null);
        TextView textViewOrders= findViewById(R.id.textViewOrders);
        textViewOrders.setText("");

        while(query.moveToNext()){
            String name = query.getString(1);
            String phone = query.getString(2);
            String drinkTitle = query.getString(3);
            int drinkCount = query.getInt(4);
            String foodTitle = query.getString(5);
            int foodCount = query.getInt(6);

            textViewOrders.append("\n" + "Name: " + name + " Phone: " + phone + "\n" +
                    "Заказы:" + "\n" + drinkTitle + " x " + drinkCount + "\n" +
                    foodTitle + " x " + foodCount + "\n");
        }
        query.close();
        db.close();
    }
}