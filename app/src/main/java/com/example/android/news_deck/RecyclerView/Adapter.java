package com.example.android.news_deck.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.news_deck.API.ArticleModel;
import com.example.android.news_deck.Detail.NewsDetail;
import com.example.android.news_deck.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    Context context;
    List<ArticleModel> articles;

    public Adapter(Context context, List<ArticleModel> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_article ,parent,  false );
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
          ArticleModel a = articles.get(position);
          holder.title.setText(a.getTitle());
          holder.source.setText( a.getSource().getName());
          holder.date.setText(dateTime(a.getPublishedAt()));

          String imageUrl = a.getUrlToImage();
        Glide.with(context).load(imageUrl).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context , NewsDetail.class);
                i.putExtra("title" , a.getTitle() );
                i.putExtra("content" , a.getContent() );
                i.putExtra("description" , a.getDescription() );
                i.putExtra("image" , a.getUrlToImage() );
                i.putExtra("url" , a.getUrl() );

                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title , source , date;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.article_title);
            source = itemView.findViewById(R.id.article_source);
            date = itemView.findViewById(R.id.article_date);
            imageView = itemView.findViewById(R.id.article_image);
            cardView = itemView.findViewById(R.id.article_cardView);

        }
    }


    public String dateTime(String t ){
        PrettyTime prettyTime = new PrettyTime(new Locale("india"));
        String time = null;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:",Locale.ENGLISH);
            Date date = simpleDateFormat.parse(t);
            time = prettyTime.format(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
          return time;
    }


}
