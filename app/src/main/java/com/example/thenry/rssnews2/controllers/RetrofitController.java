package com.example.thenry.rssnews2.controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.thenry.rssnews2.api.NewsService;
import com.example.thenry.rssnews2.dao.Article;
import com.example.thenry.rssnews2.model.FeedArticle;
import com.example.thenry.rssnews2.model.RssFeed;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by thenry on 22/02/2017.
 */

public class RetrofitController implements Callback<RssFeed> {

    static final String BASE_URL = "http://www.lemonde.fr";
    private Retrofit retrofit;
    private NewsService newsService;
    private Context ctx;

    public RetrofitController(Context context) {

        this.ctx=context;

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        this.newsService=retrofit.create(NewsService.class);
    }

    public void callFeed(){
        Call<RssFeed> call = newsService.loadRssFeed();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {

        if (response.isSuccessful()) {

            SQLite.delete(Article.class); // on nettoie la bdd
            RssFeed rssFeed = response.body();

            for (FeedArticle feedArticle : rssFeed.getArticleList()) {
                Article article = new Article();
                article.setTitle(feedArticle.getTitle());
                article.setDate(feedArticle.getDate());
                article.setDescription(feedArticle.getDescription());
                article.setImgLink(feedArticle.getImage());
                article.save();
            }
        }
        else {
            Toast.makeText(ctx, "Impossible de récupérer les données", Toast.LENGTH_SHORT).show();
            Log.e("RESPONSE","Réponse pourrie");
        }
    }

    @Override
    public void onFailure(Call<RssFeed> call, Throwable t) {
        Toast.makeText(ctx, "Impossible de récupérer les données", Toast.LENGTH_SHORT).show();
        Log.e("CALL","Call foiré");
    }
}
