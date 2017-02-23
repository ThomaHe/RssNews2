package com.example.thenry.rssnews2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.thenry.rssnews2.R;
import com.example.thenry.rssnews2.controllers.RecyclerAdapter;
import com.example.thenry.rssnews2.controllers.RetrofitController;
import com.example.thenry.rssnews2.model.Article;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements ItemClickListener{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeLayout;

    private RecyclerAdapter recyclerAdapter;
    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        final RetrofitController retrofitController = new RetrofitController(getApplicationContext());
        retrofitController.callFeed();

        articleList = SQLite.select().from(Article.class).queryList();

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(),articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setClickListener(this);

        // fonction appelée lors du pull to refresh
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrofitController.callFeed();
                articleList = SQLite.select().from(Article.class).queryList();
                recyclerAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onClick(View view, int position){
        int key = articleList.get(position).getId();
        Intent myIntent = new Intent(this, DetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("idArticle",key);
        myIntent.putExtras(extras);
        startActivity(myIntent);
    }
}
