package com.example.farukov_pr_26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    String drink;
    String food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imagePreview = findViewById(R.id.imagePreviewDrink);

        Bundle arguments = getIntent().getExtras();
        drink = arguments.get("drink").toString();
        food = arguments.get("food").toString();

        if(drink.equals("coffee")){
            imagePreview.setImageResource(R.drawable.image_coffee);
        }
        else{
            imagePreview.setImageResource(R.drawable.image_tea);
        }
    }
    public void Click(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:-0.45609946, -90.26607513"));
        startActivity(intent);
    }
    public void ClickSend(View view) {

        EditText editTextName = findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        String phone = editTextPhone.getText().toString();

//        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER, name TEXT, phone TEXT, UNIQUE(id))");
//        Cursor query = db.rawQuery("SELECT * FROM users;", null);
//        int costUser = 1;
//        while(query.moveToNext()){
//            costUser += 1;
//        }
//        query.close();
//        db.execSQL("INSERT OR IGNORE INTO users VALUES (" + costUser + ", '" + name + "', '" + phone + "');");
//
//        db.close();

        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        intent.putExtra("drink", drink);
        intent.putExtra("food", food);
        intent.putExtra("name", name);
        intent.putExtra("phone", phone);

        startActivity(intent);
    }
}