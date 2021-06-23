package com.example.taskmiletap.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmiletap.CatogaryWise;
import com.example.taskmiletap.ItemDetails;
import com.example.taskmiletap.Pojos.Category;
import com.example.taskmiletap.Pojos.Product;
import com.example.taskmiletap.R;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyViewHolder> {

    private ArrayList arrayList;
    private int id;
    private Context context;

    public TrendingAdapter(ArrayList arraylist, int id, Context context)
    {
        this.arrayList = arraylist;
        this.id = id;
        this.context = context;
    }

    @NonNull
    @Override
    public TrendingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TrendingAdapter.MyViewHolder holder, int position) {

        String type = null;
        Product p = null;

        //id =1 == Trending Product
        if(id == 1) {
            Product product_item = (Product) arrayList.get(position);

            holder.img.setImageResource(product_item.getImgUrl());
            holder.name.append(" " + product_item.getProductName());
            holder.category.append(" " + product_item.getProductCategory());
            holder.type.setText("Product");
            p = product_item;
        }
        else if (id == 2)
        {
            Category item = (Category) arrayList.get(position);

            holder.img.setImageResource(item.getUrl());
            holder.name.setVisibility(View.GONE);
            holder.name.setText(" " + item.getCatogary_Name());
            holder.category.append(" " + item.getCatogary_Name());
            holder.type.setText("Category");

            type = item.getCatogary_Name();
        }
        else
        {
            Product product_item = (Product) arrayList.get(position);
            holder.layout.setOrientation(LinearLayout.HORIZONTAL);
            holder.img.setImageResource(product_item.getImgUrl());
            holder.name.append(" " +product_item.getProductName());
            holder.category.append(" " + product_item.getProductCategory());
            holder.description.setVisibility(View.VISIBLE);
            holder.description.append(" " + product_item.getDescription());
            holder.type.setText("All");
            p = product_item;


        }

        final String finalType = type;
        final Product finalP = p;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String al = holder.type.getText().toString();
                Log.i("--Type", holder.type.getText().toString());
                if(al.equals("All"))
                {
                    Log.i("--Products page", holder.type.getText().toString());
                    Intent i = new Intent(context, ItemDetails.class);
                    i.putExtra("Name", finalP.getProductName());
                    i.putExtra("Category", finalP.getProductCategory());
                    i.putExtra("Image", finalP.getImgUrl());
                    i.putExtra("Description", finalP.getDescription());
                    view.getContext().startActivity(i);

                }
                else if (al.equals("Product"))
                {
                    Log.i("--Products page", holder.type.getText().toString());
                    Intent i = new Intent(context, ItemDetails.class);
                    i.putExtra("Name", finalP.getProductName());
                    i.putExtra("Category", finalP.getProductCategory());
                    i.putExtra("Image", finalP.getImgUrl());
                    i.putExtra("Description", finalP.getDescription());
                    view.getContext().startActivity(i);

                }
                else if (al.equals("Category"))
                {
                    Intent i = new Intent(context, CatogaryWise.class);
                    if(finalType != null)
                        i.putExtra("Category", finalType );
//                    i.putStringArrayListExtra("Arraylist", arrayList);
                    view.getContext().startActivity(i);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name, category, description, type;
        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.item_Name);
            category = (TextView) itemView.findViewById(R.id.item_Category);
            layout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            description = (TextView) itemView.findViewById(R.id.description);
            type = (TextView) itemView.findViewById(R.id.type);
        }
    }
}
