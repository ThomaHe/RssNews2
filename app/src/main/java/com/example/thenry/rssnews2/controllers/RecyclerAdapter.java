package com.example.thenry.rssnews2.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thenry.rssnews2.R;
import com.example.thenry.rssnews2.dao.Article;
import com.example.thenry.rssnews2.ui.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by thenry on 22/02/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context ctx;
    private ItemClickListener clickListener;
    private List<Article> articleList;

    public RecyclerAdapter(Context ctx,List<Article> articles) {
        this.ctx = ctx;
        this.articleList=articles;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{   // Holder correspond à une ligne de la liste

        public ImageView img_article;
        public TextView title_article;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_article=(ImageView) itemView.findViewById(R.id.img_list);
            title_article=(TextView) itemView.findViewById(R.id.title_list);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())   // on inflate le holder à partir du layout de ligne
                .inflate(R.layout.item_rss, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        final Article article = articleList.get(position);

        holder.title_article.setText(article.getTitle());
        Picasso.with(ctx).load(article.getImgLink()).into(holder.img_article); // on récupère l'image avec la librairie picasso
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}
