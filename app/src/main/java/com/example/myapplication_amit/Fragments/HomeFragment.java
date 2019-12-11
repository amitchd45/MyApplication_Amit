package com.example.myapplication_amit.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myapplication_amit.Adapters.AdapterGrid;
import com.example.myapplication_amit.Adapters.PojoGrid;
import com.example.myapplication_amit.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    GridView gridView;

    AdapterGrid adapterGrid;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        fildIds(view);
        gridList();

        return view;
    }

    private void gridList() {

        String[] listTitle = {"Sall And Buy", "Auto-Moto", "Property", "Tour Management", "Study Meterial",
                "Services", "Entertainment", "Dating", "Chat", "Partenariat", "Lifestyle", "Bet", "Fitness & Food", "Meteor", "Map", "Yabisso Pay"};
        int[] images = {R.drawable.ic_shopping_cart, R.drawable.ic_car, R.drawable.ic_assets,
                R.drawable.ic_destination, R.drawable.ic_teach, R.drawable.ic_service,
                R.drawable.ic_launcher_background, R.drawable.ic_date, R.drawable.ic_chat_1,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        int[] colors = {R.color.red, R.color.yellow, R.color.blue, R.color.green,
                R.color.red, R.color.yellow, R.color.blue, R.color.green,
                R.color.red, R.color.yellow, R.color.blue, R.color.green,
                R.color.red, R.color.yellow, R.color.blue, R.color.green};
//        list = new ArrayList<PojoGrid>();
//
//        list.add(new PojoGrid("abc"));

        AdapterGrid adapterGrid = new AdapterGrid(getContext(), listTitle, images, colors);
        gridView.setAdapter(adapterGrid);

    }

    private void fildIds(View view) {
        gridView = view.findViewById(R.id.grid_list);
    }

}
