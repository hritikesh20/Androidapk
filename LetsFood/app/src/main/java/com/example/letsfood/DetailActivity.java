package com.example.letsfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.letsfood.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    int count = 1;
    int ans = 1;
    String finalAmount;
    String newCount;
    ActivityDetailBinding detailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());

        Intent intent = getIntent();

        final int image = intent.getIntExtra("image", 0);
        final int price = Integer.parseInt(intent.getStringExtra("price"));
        final String name = intent.getStringExtra("name");
        final String description = intent.getStringExtra("desc");

        detailBinding.detailImage.setImageResource(image);
        detailBinding.detailName.setText(name);
        detailBinding.detailPrice.setText(String.format("%d", price));
        detailBinding.detailDescription.setText(description);

        final DBHelper helper = new DBHelper(this);
        detailBinding.detailBtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertOrder(
                        detailBinding.detailEnterName.getText().toString(),
                        detailBinding.detailEnterPhoneNo.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(detailBinding.quantityCount.getText().toString())
                );
                if (isInserted) {
                    Toast.makeText(DetailActivity.this, "Data Add Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(DetailActivity.this, "Thank you for Shopping with use", Toast.LENGTH_SHORT).show();
            }
        });

        detailBinding.detailbtnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                newCount = String.valueOf(count);
                detailBinding.quantityCount.setText(newCount);

                ans = price * count;
                finalAmount = String.valueOf(ans);
                detailBinding.detailPrice.setText(finalAmount);
            }
        });

        detailBinding.detailbtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) {
                    count--;
                    newCount = String.valueOf(count);
                    detailBinding.quantityCount.setText(newCount);
                    ans = ans - price;
                    finalAmount = String.valueOf(ans);
                    detailBinding.detailPrice.setText(finalAmount);
                } else {
                    Toast.makeText(DetailActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}