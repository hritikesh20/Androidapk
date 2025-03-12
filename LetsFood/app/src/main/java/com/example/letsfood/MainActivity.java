package com.example.letsfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageSwitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.letsfood.adapters.MainAdapter;
import com.example.letsfood.databinding.ActivityMainBinding;
import com.example.letsfood.models.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainModel> list;
    MainAdapter adapter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add(new MainModel(R.drawable.shoes4, "Nike Max 1", "25999", "Speed Bold"));
        list.add(new MainModel(R.drawable.shoes10, "Nike Jorden", "9999", "Speed Bold"));
        list.add(new MainModel(R.drawable.shoes11, "Nike Lalu", "17999", "Speed Bold"));
        list.add(new MainModel(R.drawable.shoes14, "Nike Gold", "20999", "Speed Bold"));
        list.add(new MainModel(R.drawable.shoes12, "Nike Boss", "11999", "Speed Bold"));
        list.add(new MainModel(R.drawable.shoes5, "Nike jorden Pro max", "6999", "Speed Bold"));
        list.add(new MainModel(R.drawable.shoes7, "Nike New One", "28999", "Speed Bold"));

        adapter = new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.orders) {
            startActivity(new Intent(MainActivity.this, OrderActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}