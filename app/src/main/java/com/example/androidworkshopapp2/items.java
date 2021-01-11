package com.example.androidworkshopapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class items extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        ArrayList<Item> items = (ArrayList<Item>) getIntent().getSerializableExtra("ITEMS");

        ArrayAdapter adapter = new ItemsAdapter(this, 0, items);

        ListView listView = (ListView) findViewById(R.id.items_list);
        listView.setAdapter(adapter);

    }
}