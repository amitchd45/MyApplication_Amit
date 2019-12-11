package com.example.myapplication_amit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication_amit.Adapters.CategoryAdapter;
import com.example.myapplication_amit.Adapters.FragrancesAdapter;
import com.example.myapplication_amit.Adapters.ViewPagerAdapter;
import com.example.myapplication_amit.R;

public class SellAndBuyActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    RecyclerView recyclerView,recyclerView_1,recyclerView_2;
    CategoryAdapter categoryAdapter;
    FragrancesAdapter fragrancesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_and_buy);


        list();
        Fragranceslist();

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void list() {

        String[] categoryName = {"Phone", "Phone", "Phone", "Phone", "Phone", "Phone"};
        int[] categoryImage = {R.drawable.ic_service, R.drawable.ic_service, R.drawable.ic_service,
                R.drawable.ic_service, R.drawable.ic_service, R.drawable.ic_service};

        recyclerView = findViewById(R.id.recycler_view);

        categoryAdapter = new CategoryAdapter(this, categoryName, categoryImage);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(SellAndBuyActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }

    private void Fragranceslist() {

        String[] fragranceName = {"Phone", "Phone", "Phone", "Phone", "Phone", "Phone"};
        int[] fragranceImage = {R.drawable.ic_service, R.drawable.ic_service, R.drawable.ic_service,
                R.drawable.ic_service, R.drawable.ic_service, R.drawable.ic_service};

        recyclerView_1 = findViewById(R.id.recycler_view_fragrance);

        fragrancesAdapter = new FragrancesAdapter(this, fragranceName, fragranceImage);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(SellAndBuyActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_1.setLayoutManager(horizontalLayoutManagaer);
        recyclerView_1.setAdapter(fragrancesAdapter);
        fragrancesAdapter.notifyDataSetChanged();
    }

}
