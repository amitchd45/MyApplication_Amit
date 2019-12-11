package com.example.myapplication_amit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_amit.R;

public class FragrancesAdapter extends RecyclerView.Adapter<FragrancesAdapter.MyViewHolder> {

    Context context;
    String[] fragranceName;
    int[] fragranceImage;

    public FragrancesAdapter(Context context, String[] fragranceName, int[] fragranceImage) {
        this.context = context;
        this.fragranceName = fragranceName;
        this.fragranceImage = fragranceImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fragrance, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mFragranceImage.setImageResource(fragranceImage[position]);
        holder.mFragranceName.setText(fragranceName[position]);

    }

    @Override
    public int getItemCount() {
        return fragranceName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mFragranceImage;
        TextView mFragranceName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mFragranceImage = itemView.findViewById(R.id.iv_fragrance_image);
            mFragranceName = itemView.findViewById(R.id.tv_fragrances_name);
        }
    }
}
