package com.example.taskmiletap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.taskmiletap.Adapters.TrendingAdapter;
import com.example.taskmiletap.Pojos.Category;
import com.example.taskmiletap.Pojos.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView_trendingProducts, recyclerView_Category, recyclerView_AllProducts;
    ArrayList<Product> productArrayList;
    ArrayList<Category> categoryArraylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        productArrayList = new ArrayList<>();
        categoryArraylist = new ArrayList<>();

        Product[] products = new Product[]
                {
                        new Product(0, "Fried Chicken", "Fast Food", R.drawable.friedchicken,
                                "Deep Fried Chicken with cripsy texture outside", 10),

                        new Product(1, "Zinger Burger", "Fast Food", R.drawable.zinger,
                                "Crispy chicken zinger burger with lettuce, onion and sauce", 15),

                        new Product(2, "Chicken Karahi", "Desi Food", R.drawable.karahi,
                                "Chicken karahi ", 15),

                        new Product(3, "Chicken Chow mein", "Chinese Food", R.drawable.chowmein,
                                "Chicken chowmein chinese dish with sauces ", 15)

                };

        Category[] categories = new Category[]
                {
                        new Category(0, "Fast Food", R.drawable.fastfood),
                        new Category(1, "Desi Food", R.drawable.desi),
                        new Category(2, "Chinese", R.drawable.chinese)

                };


        productArrayList.addAll(Arrays.asList(products));
        categoryArraylist.addAll(Arrays.asList(categories));
//        Log.i("--Items", Arrays.asList(products) + " ");

        TrendingAdapter trendingAdapter = new TrendingAdapter(productArrayList,1, getApplicationContext());
        recyclerView_trendingProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_trendingProducts.setAdapter(trendingAdapter);


        TrendingAdapter adapter_1 = new TrendingAdapter(categoryArraylist,2, getApplicationContext());
        recyclerView_Category.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_Category.setAdapter(adapter_1);


        TrendingAdapter adapter_2 = new TrendingAdapter(productArrayList,0, getApplicationContext());
        recyclerView_AllProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_AllProducts.setAdapter(adapter_2);







    }

    private void init()
    {
        recyclerView_trendingProducts = (RecyclerView) findViewById(R.id.trendingProducts);
        recyclerView_Category = (RecyclerView) findViewById(R.id.category_Recycler);
        recyclerView_AllProducts = (RecyclerView) findViewById(R.id.allProducts_recycler);
    }
}
