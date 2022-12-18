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
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    int costDrink;
    int costFood;
    int countDrink = 1;
    int countFood = 1;

    String drinkOrder;
    String foodOrder;
    String name;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // Данные клиента
        TextView textNamePhone = findViewById(R.id.textNamePhone);
        // Данные о напитке
        ImageView imagePreviewDrink = findViewById(R.id.imagePreviewDrink);
        TextView textViewDrink = findViewById(R.id.textViewDrink);
        TextView textViewDrinkPrice = findViewById(R.id.textViewDrinkPrice);
        // Данные о блюде
        ImageView imagePreviewFood = findViewById(R.id.imagePreviewFood);
        TextView textViewFood = findViewById(R.id.textViewFood);
        TextView textViewFoodPrice = findViewById(R.id.textViewFoodPrice);

        Bundle arguments = getIntent().getExtras();
        String drink = arguments.get("drink").toString();
        String food = arguments.get("food").toString();
        name = arguments.get("name").toString();
        phone = arguments.get("phone").toString();

        textNamePhone.setText(name + "\n" + phone);

        if(drink.equals("coffee")){
            imagePreviewDrink.setImageResource(R.drawable.image_coffee);
            drinkOrder = "Кофе с карамелью";
            textViewDrink.setText(drinkOrder);
            costDrink = 250;
        }
        else{
            imagePreviewDrink.setImageResource(R.drawable.image_tea);
            drinkOrder = "Черный чай";
            textViewDrink.setText(drinkOrder);
            costDrink = 150;
        }
        textViewDrinkPrice.setText(costDrink + " рублей");

        if(food.equals("sweet")){
            imagePreviewFood.setImageResource(R.drawable.image_sweets);
            foodOrder = "Чизкейк Клубника";
            textViewFood.setText(foodOrder);
            costFood = 230;
        }
        else{
            imagePreviewFood.setImageResource(R.drawable.image_combo);
            foodOrder = "Яичница";
            textViewFood.setText(foodOrder);
            costFood = 200;
        }
        textViewFoodPrice.setText(costFood + " рублей");

        UpdateResult();
    }

    public void UpdateResult() {
        TextView textViewDrinkCount = findViewById(R.id.textViewDrinkCount);
        TextView textViewFoodCount = findViewById(R.id.textViewFoodCount);
        TextView textViewResult = findViewById(R.id.textViewResult);
        int result = costDrink * countDrink + costFood * countFood;

        textViewDrinkCount.setText("" + countDrink);
        textViewFoodCount.setText("" + countFood);
        textViewResult.setText(result + " рублей");
    }

    public void ClickDrinkMinus(View view) {
        if(countDrink > 0){
            countDrink -= 1;
            UpdateResult();
        }
    }
    public void ClickDrinkPlus(View view) {
        countDrink += 1;
        UpdateResult();
    }
    public void ClickFoodMinus(View view) {
        if(countFood > 0) {
            countFood -= 1;
            UpdateResult();
        }
    }
    public void ClickFoodPlus(View view) {
        countFood += 1;
        UpdateResult();
    }

    public void ClickBuy(View view) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER, name TEXT, phone TEXT, drinkTitle TEXT, drinkCount INTEGER, foodTitle TEXT, foodCount INTEGER, UNIQUE(id))");
        Cursor query = db.rawQuery("SELECT * FROM orders;", null);
        int costUser = 1;
        while(query.moveToNext()){
            costUser += 1;
        }
        query.close();
        db.execSQL("INSERT OR IGNORE INTO orders VALUES (" + costUser + ", '" + name + "', '" + phone +
                "', '" + drinkOrder + "', " + countDrink + ", '" + foodOrder + "', " + countFood + ");");

        db.close();

        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);
    }
}