package com.example.myapplication_amit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.myapplication_amit.Activities.SellAndBuyActivity;
import com.example.myapplication_amit.R;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {

    Context context;
    ArrayList<PojoGrid> pojoGrids;


    String [] listTitle;
    int [] images;
    int [] colors;



    public AdapterGrid(Context context, String[] listTitle, int[] images, int[] colors) {
        this.context = context;
        this.listTitle = listTitle;
        this.images = images;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return listTitle.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        TextView mTitle = view.findViewById(R.id.tv_title);
        ImageView mImage = view.findViewById(R.id.iv_image);
        CardView mCard = view.findViewById(R.id.cardview);

        mTitle.setText(listTitle[position]);
        mTitle.setTextColor(context.getResources().getColor(colors[position]));
        mImage.setImageResource(images[position]);
        mCard.setCardBackgroundColor(context.getResources().getColor(colors[position]));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, SellAndBuyActivity.class));
            }
        });


        return view;
    }
}
