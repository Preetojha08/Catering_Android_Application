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
    List<String> sub_title;
    List<Integer> images;
    Context context;
    int card_val=0;
    LayoutInflater layoutInflater;


    public RecyclerViewAdapter(List<String> title, List<String> sub_title, List<Integer> images, Context context, int card_val) {
        this.title = title;
        this.sub_title = sub_title;
        this.images = images;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.card_val = card_val;
    }

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
        else if (card_val==30)
        {
            view_oncreate = layoutInflater.inflate(R.layout.event_cards,parent,false);
        }
        else if (card_val==40)
        {
            view_oncreate = layoutInflater.inflate(R.layout.food_deatils,parent,false);
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
        if (card_val==30)
        {
            holder.event_text.setText(title.get(position));
            holder.event_img.setImageResource(images.get(position));
        }
        if (card_val==40)
        {
            holder.food_destails_title_textview.setText(title.get(position));
            holder.food_destails_sub_title_textview.setText(sub_title.get(position));
            holder.food_deatils_imgaeview.setImageResource(images.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class recycler_view_holder extends RecyclerView.ViewHolder{

        ImageView food_by_cat_imageview,book_by_thali_imageview;
        TextView food_by_cat_tv,book_by_thali_tv;

        ImageView event_img;
        TextView event_text;

        ImageView food_deatils_imgaeview;
        TextView food_destails_title_textview,food_destails_sub_title_textview;



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
            if (card_val==30)
            {
                event_img=(ImageView)itemView.findViewById(R.id.event_image_view);
                event_text=(TextView)itemView.findViewById(R.id.event_title_text_view);
            }

            if (card_val==40)
            {
                food_deatils_imgaeview=(ImageView)itemView.findViewById(R.id.food_details_imageview);
                food_destails_title_textview=(TextView)itemView.findViewById(R.id.food_details_title_textview);
                food_destails_sub_title_textview=(TextView)itemView.findViewById(R.id.food_details_dec_textview);

            }

        }
    }

}
