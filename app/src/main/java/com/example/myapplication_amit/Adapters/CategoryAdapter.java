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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    Context context;
    String[] categoryName;
    int[] categoryImage;

    public CategoryAdapter(Context context, String[] categoryName, int[] categoryImage) {
        this.context = context;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mCategoryImage.setImageResource(categoryImage[position]);
        holder.mCategoryName.setText(categoryName[position]);

    }

    @Override
    public int getItemCount() {
        return categoryName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mCategoryImage;
        TextView mCategoryName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mCategoryImage = itemView.findViewById(R.id.iv_category_image);
            mCategoryName = itemView.findViewById(R.id.tv_category_name);
        }
    }
}
