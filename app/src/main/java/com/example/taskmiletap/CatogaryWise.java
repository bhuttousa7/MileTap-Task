package com.example.taskmiletap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.taskmiletap.Adapters.TrendingAdapter;
import com.example.taskmiletap.Pojos.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class CatogaryWise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        ArrayList<Product> productArrayList;
        RecyclerView allProducts_recycler;

        allProducts_recycler = (RecyclerView) findViewById(R.id.allProducts_recycler);

        Intent intent = getIntent();
        String categoryType = intent.getStringExtra("Category");

        Product[] products = new Product[]{

        };

        if(categoryType.equals("Chinese"))
        {
            products = new Product[]
                {
                        new Product(3, "Chicken Chow mein", "Chinese Food", R.drawable.chowmein,
                                "Chicken chowmein chinese dish with sauces ", 15)
                };

        }
        else if (categoryType.equals("Desi Food"))
        {
            products = new Product[]
                    {
                            new Product(2, "Chicken Karahi", "Desi Food", R.drawable.karahi,
                                    "Chicken karahi ", 15)

                    };

        }
        else if (categoryType.equals("Fast Food"))
        {
            products = new Product[]
                    {
                            new Product(0, "Fried Chicken", "Fast Food", R.drawable.friedchicken,
                                    "Deep Fried Chicken with cripsy texture outside", 10),

                            new Product(1, "Zinger Burger", "Fast Food", R.drawable.zinger,
                                    "Crispy chicken zinger burger with lettuce, onion and sauce", 15)

                    };
        }


        getSupportActionBar().setTitle("All Products");


        productArrayList = new ArrayList<>();
        productArrayList.addAll(Arrays.asList(products));


        TrendingAdapter adapter_1 = new TrendingAdapter(productArrayList,1, getApplicationContext());
        allProducts_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        allProducts_recycler.setAdapter(adapter_1);



//        Log.i("--Intent arraylist", getIntent().getStringArrayListExtra("Arraylist") + " ");



    }
}
