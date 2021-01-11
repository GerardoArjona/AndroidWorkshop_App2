package com.example.androidworkshopapp2;

import android.widget.EditText;

import java.io.Serializable;

public class Item implements Serializable {

    int id;
    String designer;
    String season;
    String collection;
    String clothingName;
    String brand;

    public Item(int id, String designer, String season, String collection, String clothingName, String brand) {
        this.id = id;
        this.brand = brand;
        this.clothingName = clothingName;
        this.collection = collection;
        this.season = season;
        this.designer = designer;
    }

    //DESIGNER
    public void setDesigner( String designer ) {
        this.designer = designer;
    }

    public String getDesigner( ) {
        return designer;
    }

    //SEASON
    public void setSeason( String season ) {
        this.season = season;
    }

    public String getSeason( ) {
        return season;
    }

    //COLLECTION
    public void setCollection( String collection ) {
        this.collection = collection;
    }

    public String getCollection( ) {
        return collection;
    }

    //CLOTHING NAME
    public void setClothingName( String clothingName ) {
        this.clothingName = clothingName;
    }

    public String getClothingName( ) {
        return clothingName;
    }

    //BRAND
    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public String getBrand( ) {
        return brand;
    }



}
