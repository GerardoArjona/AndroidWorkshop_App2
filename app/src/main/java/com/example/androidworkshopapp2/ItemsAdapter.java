package com.example.androidworkshopapp2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<Item> {
    private Activity activity;
    private ArrayList<Item> items;
    private static LayoutInflater inflater = null;

    public ItemsAdapter (Activity activity, int textViewResourceId,ArrayList<Item> _items) {
        super(activity, textViewResourceId, _items);
        try {
            this.activity = activity;
            this.items = _items;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return items.size();
    }

    public Item getItem(Item position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_clothingName;
        public TextView display_collection;
        public TextView display_season;
        public TextView display_designer;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.single_item, null);
                holder = new ViewHolder();

                holder.display_clothingName = (TextView) vi.findViewById(R.id.tvClothingNameSingleItem);
                holder.display_collection = (TextView) vi.findViewById(R.id.tvCollectionSingleItem);
                holder.display_season = (TextView) vi.findViewById(R.id.tvSeasonSingleItem);
                holder.display_designer = (TextView) vi.findViewById(R.id.tvDesignerSingleItem);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.display_clothingName.setText(items.get(position).clothingName);
            holder.display_collection.setText(items.get(position).collection);
            holder.display_season.setText(items.get(position).season);
            holder.display_designer.setText(items.get(position).designer);


        } catch (Exception e) {


        }
        return vi;
    }
}