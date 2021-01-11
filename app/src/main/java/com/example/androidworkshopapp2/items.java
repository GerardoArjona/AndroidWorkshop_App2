package com.example.androidworkshopapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class items extends AppCompatActivity {

    ArrayAdapter adapter;
    ArrayList<Item> items;
    Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mainIntent = new Intent(getBaseContext(), MainActivity.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        items = (ArrayList<Item>) getIntent().getSerializableExtra("ITEMS");

        adapter = new ItemsAdapter(this, 0, items);

        ListView listView = (ListView) findViewById(R.id.items_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), getString(R.string.idToast) + items.get(position).id ,Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean deleteItemFromList(View view) {

        int position = (Integer) view.getTag();
        items.remove(position);
        adapter.notifyDataSetChanged();

        mainIntent.putExtra("NEW_ITEMS", items);

        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(mainIntent);
    }

}