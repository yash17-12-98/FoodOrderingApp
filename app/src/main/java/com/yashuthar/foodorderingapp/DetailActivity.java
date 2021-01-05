package com.yashuthar.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    Button orderButton;
    ImageView detailImg;
    EditText nameBox, phoneBox;
    TextView detailName, detailDescription, detailPrice, quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailImg = (ImageView) findViewById(R.id.detailImg);
        detailName = (TextView) findViewById(R.id.detailName);
        detailDescription = (TextView) findViewById(R.id.detailDescription);
        detailPrice = (TextView) findViewById(R.id.detailPrice);
        quantity = (TextView) findViewById(R.id.quantity);
        orderButton = (Button) findViewById(R.id.orderButton);
        nameBox = (EditText) findViewById(R.id.nameBox);
        phoneBox = (EditText) findViewById(R.id.phoneBox);

        final DBHelpers helpers = new DBHelpers(this);

        if(getIntent().getIntExtra("type", 0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));

            detailImg.setImageResource(image);
            detailName.setText(name);
            detailDescription.setText(description);
            detailPrice.setText(String.format("%d", price));


            orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = helpers.insertOrders(
                            nameBox.getText().toString(),
                            phoneBox.getText().toString(),
                            price,
                            image,
                            description,
                            name,
                            Integer.parseInt(quantity.getText().toString()));
                    if (isInserted) {
                        Intent intent = new Intent(DetailActivity.this, OrderActivity.class);
                        startActivity(intent);
                        Toast.makeText(DetailActivity.this, "You Ordered " + name, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helpers.getOrderById(id);
            int image = cursor.getInt(4);
            detailImg.setImageResource(image);
            detailName.setText(cursor.getString(7));
            detailDescription.setText(cursor.getString(6));
            detailPrice.setText(String.format("%d", cursor.getInt(3)));
            nameBox.setText(cursor.getString(1));
            phoneBox.setText(cursor.getString(2));

            orderButton.setText("Update Now");

            orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdated = helpers.updateOrders(
                            nameBox.getText().toString(),
                            phoneBox.getText().toString(),
                            Integer.parseInt(detailPrice.getText().toString()),
                            image,
                            detailDescription.getText().toString(),
                            detailName.getText().toString(),
                            1,
                            id
                    );
                    if(isUpdated){
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(DetailActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}