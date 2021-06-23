package com.example.taskmiletap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetails extends AppCompatActivity {


    ImageView img_view;
    TextView item_detail_name, item_detail_category, item_detail_decription, textcounter;
    String name, category, description;
    int url;
    ImageButton imageButtonPlus, imageButtonMinus;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        init();

        Intent i = getIntent();
        name = i.getStringExtra("Name");
        category = i.getStringExtra("Category");
        url = i.getIntExtra("Image", 0);
        description = i.getStringExtra("Description");


        img_view.setImageResource(url);
        item_detail_name.append(" " + name);
        item_detail_category.append( " " + category);
        item_detail_decription.append(" " + description);

        imageButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                textcounter.setText(count + "");

            }
        });

        imageButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count <= 0) {

                }
                else
                {
                    count -= 1;
                    textcounter.setText(count + "");
                }
            }
        });




    }
    private void init()
    {
        img_view = (ImageView) findViewById(R.id.img_view);
        item_detail_name = (TextView) findViewById(R.id.item_detail_name);
        item_detail_category = (TextView) findViewById(R.id.item_detail_category);
        item_detail_decription = (TextView) findViewById(R.id.item_detail_Description);
        imageButtonPlus = (ImageButton) findViewById(R.id.plus);
        imageButtonMinus = (ImageButton) findViewById(R.id.minus);
        textcounter = (TextView) findViewById(R.id.textcounter);

    }
}
