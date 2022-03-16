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
    int card_val=0;

    public RecyclerViewAdapter(List<String> title, List<Integer> images, Context context,int card_val) {
        this.title = title;
        this.images = images;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.card_val = card_val;
    }

    @NonNull
    @Override
    public recycler_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_oncreate;

        if (card_val==10){
            view_oncreate = layoutInflater.inflate(R.layout.food_by_categories,parent,false);

        }
        else if (card_val==20)
        {
            view_oncreate = layoutInflater.inflate(R.layout.book_by_thali,parent,false);

        }
        else {
            view_oncreate = layoutInflater.inflate(R.layout.food_by_categories,parent,false);
        }
        return new recycler_view_holder(view_oncreate);


    }


    @Override
    public void onBindViewHolder(@NonNull recycler_view_holder holder, int position) {

        if (card_val==10)
        {
            holder.food_by_cat_tv.setText(title.get(position));
            holder.food_by_cat_imageview.setImageResource(images.get(position));
        }
        if (card_val==20)
        {
            holder.book_by_thali_tv.setText(title.get(position));
            holder.book_by_thali_imageview.setImageResource(images.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class recycler_view_holder extends RecyclerView.ViewHolder{

        ImageView food_by_cat_imageview,book_by_thali_imageview;
        TextView food_by_cat_tv,book_by_thali_tv;

        public recycler_view_holder(@NonNull View itemView) {
            super(itemView);

            if (card_val==10)
            {
                food_by_cat_imageview=(ImageView)itemView.findViewById(R.id.image_view_foodbycat);
                food_by_cat_tv=(TextView)itemView.findViewById(R.id.text_view_foodbycat);
            }
            if (card_val==20)
            {
                book_by_thali_imageview=(ImageView)itemView.findViewById(R.id.image_view_bookbythali);
                book_by_thali_tv=(TextView)itemView.findViewById(R.id.text_view_bookbythali);
            }

        }
    }

}
