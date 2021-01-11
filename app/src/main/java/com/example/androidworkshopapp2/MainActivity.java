package com.example.androidworkshopapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText etClothingName;
    EditText etCollection;
    EditText etSeason;
    EditText etDesigner;
    TextView tvCount;
    String brand;

    List<String> brands  = new ArrayList<>();
    ArrayList<Item> items  = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brands.add(getString(R.string.lv));
        brands.add(getString(R.string.gucci));
        brands.add(getString(R.string.fendi));
        brands.add(getString(R.string.ferragamo));
        brands.add(getString(R.string.hermes));

        etClothingName = findViewById(R.id.editTextClothingName);
        etCollection = findViewById(R.id.editTextCollection);
        etSeason = findViewById(R.id.editTextSeason);
        etDesigner = findViewById(R.id.editTextDesigner);

        tvCount = findViewById(R.id.tvCount);

        //Brands Spinner
        Spinner brandsSpinner = (Spinner) findViewById(R.id.brandsSpinner);
        ArrayAdapter<String> brandsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brands);
        brandsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandsSpinner.setAdapter(brandsAdapter);
        brandsSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(getIntent().getSerializableExtra("NEW_ITEMS") != null){
            items = (ArrayList<Item>) getIntent().getSerializableExtra("NEW_ITEMS");
            tvCount.setText(String.valueOf(items.size()));
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        // Toast.makeText(getApplicationContext(), "Selected User: "+brands[position] ,Toast.LENGTH_SHORT).show();
        brand = brands.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

    public boolean addItemToList(View view) {

        if(etClothingName.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.clothingNameError) ,Toast.LENGTH_SHORT).show();
            etClothingName.setError(getString(R.string.clothingNameErrorHelp));
            return false;
        }

        if(etCollection.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.collectionError) ,Toast.LENGTH_SHORT).show();
            etCollection.setError(getString(R.string.collectionErrorHelp));
            return false;
        }

        if(etSeason.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.seasonError) ,Toast.LENGTH_SHORT).show();
            etSeason.setError(getString(R.string.seasonErrorHelp));
            return false;
        }

        if(etDesigner.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.designerError) ,Toast.LENGTH_SHORT).show();
            etDesigner.setError(getString(R.string.designerErrorHelp));
            return false;
        }

        String designer = etDesigner.getText().toString();
        String season = etSeason.getText().toString();
        String collection = etCollection.getText().toString();
        String clothingName = etClothingName.getText().toString();

        items.add(
                new Item(
                        items.size() +1,
                        designer, //Designer
                        season, //Season
                        collection, //Collection
                        clothingName, //Clothing Name
                        this.brand
                )
        );

        tvCount.setText(String.valueOf(items.size()));
        etDesigner.setText(null);
        etSeason.setText(null);
        etCollection.setText(null);
        etClothingName.setText(null);

        return true;
    }

    public boolean toItemList(View view) {

        Intent listIntent = new Intent(getBaseContext(), items.class);

        if(items.size() == 0){
            Toast.makeText(getApplicationContext(), getString(R.string.itemsError) ,Toast.LENGTH_SHORT).show();
            return false;
        }

        listIntent.putExtra("ITEMS", items);

        startActivity(listIntent);

        return true;
    }
}