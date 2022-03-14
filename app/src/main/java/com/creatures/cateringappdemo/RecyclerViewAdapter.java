package com.creatures.cateringappdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.recycler_view_holder> {

    List<String> title;
    List<Integer> images;
    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter(List<String> title, List<Integer> images, Context context) {
        this.title = title;
        this.images = images;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public recycler_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_oncreate = layoutInflater.inflate(R.layout.food_by_categories,parent,false);
        return new recycler_view_holder(view_oncreate);
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_view_holder holder, int position) {
        holder.food_by_cat_tv.setText(title.get(position));
        holder.food_by_cat_imageview.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class recycler_view_holder extends RecyclerView.ViewHolder{

        ImageView food_by_cat_imageview;
        TextView food_by_cat_tv;

        public recycler_view_holder(@NonNull View itemView) {
            super(itemView);

            food_by_cat_imageview=(ImageView)itemView.findViewById(R.id.image_view_foodbycat);
            food_by_cat_tv=(TextView)itemView.findViewById(R.id.text_view_foodbycat);
        }
    }

}
