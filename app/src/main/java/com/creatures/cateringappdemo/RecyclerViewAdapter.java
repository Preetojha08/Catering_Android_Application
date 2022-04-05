package com.creatures.cateringappdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.recycler_view_holder> {

    List<String> title;
    List<String> sub_title;
    Context context;
    List<List<SlideModel>> slide_image_models;
    int card_val=0;
    List<Integer> images;
    LayoutInflater layoutInflater;
    int pos=0;
    int menu_counter=0;

    SharedPreferences recylerviewadpter_shared_preferences;
    SharedPreferences.Editor rva_sp_editor;


    public RecyclerViewAdapter(List<String> title,Context context,int card_val)
    {
        this.title = title;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.card_val = card_val;
    }


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

        else if (card_val==60)
        {
            view_oncreate = layoutInflater.inflate(R.layout.inquiry_card,parent,false);
        }

        else if (card_val==70)
        {
            view_oncreate = layoutInflater.inflate(R.layout.menu_card,parent,false);
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

            holder.event_display_cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pos=holder.getPosition();
                    pos++;


                    if (pos==1)
                    {
                        Intent i = new Intent(context,EventDeatilsActivity.class);
                        i.putExtra("event_item",31);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==2)
                    {
                        Intent i = new Intent(context,EventDeatilsActivity.class);
                        i.putExtra("event_item",32);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==3)
                    {
                        Intent i = new Intent(context,EventDeatilsActivity.class);
                        i.putExtra("event_item",33);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==4)
                    {
                        Intent i = new Intent(context,EventDeatilsActivity.class);
                        i.putExtra("event_item",34);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==5)
                    {
                        Intent i = new Intent(context,EventDeatilsActivity.class);
                        i.putExtra("event_item",35);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==6)
                    {
                        Intent i = new Intent(context,EventDeatilsActivity.class);
                        i.putExtra("event_item",36);
                        holder.itemView.getContext().startActivity(i);
                    }

                }
            });
        }
        if (card_val==60)
        {
            holder.textview_inquiry_title.setText(title.get(position));
            holder.circleImageView_inquiry_images.setImageResource(images.get(position));
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

                    if (pos==1)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",1);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else if (pos==2)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",2);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else if (pos==3)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",3);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else if (pos==4)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",4);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else if (pos==5)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",5);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else if (pos==6)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",6);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else if (pos==7)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("food_cat_item",7);
                        holder.itemView.getContext().startActivity(i);
                    }

                    else
                    {
                        Toast.makeText(context, "Wrong Item Pressed: ", Toast.LENGTH_SHORT).show();
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


                    if (pos==1)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",11);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==2)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",12);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==3)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",13);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==4)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",14);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==5)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",15);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==6)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",16);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else if (pos==7)
                    {
                        Intent i = new Intent(context,SingleFoodDeatilsActivity.class);
                        i.putExtra("thali_deatils",17);
                        holder.itemView.getContext().startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(context, "Wrong Item Pressed: ", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        if (card_val==70)
        {
            holder.menu_title_tv.setText(title.get(position));
            holder.mneu_arrow_imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (menu_counter==0)
                    {
                        menu_counter++;
                        Animation animation_first = AnimationUtils.loadAnimation(context,R.anim.slide_down);
                        holder.mneu_arrow_imgv.animate().rotation(180);
                        holder.sub_menu_items_card_layout.startAnimation(animation_first);
                        holder.sub_menu_items_card_layout.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        menu_counter--;
                        holder.mneu_arrow_imgv.animate().rotation(360);
                        Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide_up);
                        holder.sub_menu_items_card_layout.startAnimation(animation);

                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                holder.sub_menu_items_card_layout.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });


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

        CircleImageView circleImageView_inquiry_images;
        TextView textview_inquiry_title;

        MaterialCardView event_display_cardView;
        ImageView mneu_arrow_imgv;
        TextView menu_title_tv;
        MaterialCardView sub_menu_items_card_layout;


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
                event_display_cardView=(MaterialCardView) itemView.findViewById(R.id.event_card_display);
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
            if (card_val==60)
            {
                circleImageView_inquiry_images=(CircleImageView) itemView.findViewById(R.id.circle_imageview_inquiry_card);
                textview_inquiry_title=(TextView) itemView.findViewById(R.id.textview_inquiry_card);
            }

            if (card_val==50)
            {
                card_view_food_deatils=(CardView)itemView.findViewById(R.id.card_view_food_details);
                food_deatils_imgaeview_iv=(ImageView) itemView.findViewById(R.id.food_details_imageview);
                food_destails_title_textview=(TextView)itemView.findViewById(R.id.food_details_title_textview);
                food_destails_sub_title_textview=(TextView)itemView.findViewById(R.id.food_details_dec_textview);
                food_deatils_imgaeview_iv.setVisibility(View.VISIBLE);
            }

            if (card_val==70)
            {
                menu_title_tv=(TextView)itemView.findViewById(R.id.text_view_title_menu_item);
                mneu_arrow_imgv=(ImageView)itemView.findViewById(R.id.arrow_image_view_menu);
                sub_menu_items_card_layout=(MaterialCardView)itemView.findViewById(R.id.card_view_sub_menu_items);
                sub_menu_items_card_layout.setVisibility(View.GONE);
            }

        }
    }



}