package com.creatures.cateringappdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.recycler_view_holder> {

    List<String> title;
    List<String> sub_title;
    Context context;
    List<List<SlideModel>> slide_image_models;
    int card_val=0;
    List<Integer> images;
    LayoutInflater layoutInflater;
    int pos=0;



    public RecyclerViewAdapter(List<String> title, List<String> sub_title, Context context,  List<List<SlideModel>> slide_image_models, int card_val) {
        this.title = title;
        this.sub_title = sub_title;
        this.context = context;
        this.slide_image_models = slide_image_models;
        this.layoutInflater = LayoutInflater.from(context);
        this.card_val = card_val;
    }


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
        else if (card_val==50)
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
            holder.food_deatils_imgaeview.setImageList(slide_image_models.get(position));

            holder.card_view_food_deatils.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pos=holder.getPosition();
                    pos++;
                    Toast.makeText(context, "Pressed: "+pos, Toast.LENGTH_SHORT).show();

                    if (pos==1)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        holder.itemView.getContext().startActivity(i);
                    }

                }
            });
        }

        if (card_val==50)
        {
            holder.food_destails_title_textview.setText(title.get(position));
            holder.food_destails_sub_title_textview.setText(sub_title.get(position));
            holder.food_deatils_imgaeview_iv.setImageResource(images.get(position));


            holder.card_view_food_deatils.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pos=holder.getPosition();
                    pos++;
                    Toast.makeText(context, "Pressed: "+pos, Toast.LENGTH_SHORT).show();

                    if (pos==1)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        holder.itemView.getContext().startActivity(i);
                    }

                }
            });
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

        ImageSlider food_deatils_imgaeview;
        ImageView food_deatils_imgaeview_iv;
        TextView food_destails_title_textview,food_destails_sub_title_textview;

        CardView card_view_food_deatils;


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

                card_view_food_deatils=(CardView)itemView.findViewById(R.id.card_view_food_details);
                food_deatils_imgaeview_iv=(ImageView) itemView.findViewById(R.id.food_details_imageview);
                food_deatils_imgaeview=(ImageSlider) itemView.findViewById(R.id.food_details_image_slider);
                food_destails_title_textview=(TextView)itemView.findViewById(R.id.food_details_title_textview);
                food_destails_sub_title_textview=(TextView)itemView.findViewById(R.id.food_details_dec_textview);
                food_deatils_imgaeview.setVisibility(View.VISIBLE);
                food_deatils_imgaeview_iv.setVisibility(View.GONE);

            }

            if (card_val==50)
            {
                card_view_food_deatils=(CardView)itemView.findViewById(R.id.card_view_food_details);
                food_deatils_imgaeview_iv=(ImageView) itemView.findViewById(R.id.food_details_imageview);
                food_destails_title_textview=(TextView)itemView.findViewById(R.id.food_details_title_textview);
                food_destails_sub_title_textview=(TextView)itemView.findViewById(R.id.food_details_dec_textview);
                food_deatils_imgaeview_iv.setVisibility(View.VISIBLE);

            }

        }



    }



}
