package com.example.letsfood;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.letsfood.adapters.OrderAdapter;
import com.example.letsfood.databinding.ActivityOrderBinding;
import com.example.letsfood.models.OrderModel;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding orderBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderBinding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(orderBinding.getRoot());

        DBHelper dbHelper = new DBHelper(this);

        ArrayList<OrderModel> list = dbHelper.getOrders();

        OrderAdapter adapter = new OrderAdapter(list, this);
        orderBinding.recyclerViewOrder.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        orderBinding.recyclerViewOrder.setLayoutManager(linearLayoutManager);

    }
}

