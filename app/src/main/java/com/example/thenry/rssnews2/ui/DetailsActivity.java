package com.example.thenry.rssnews2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thenry.rssnews2.R;
import com.example.thenry.rssnews2.model.Article;
import com.example.thenry.rssnews2.model.Article_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.article_title)TextView title;
    @BindView(R.id.article_img)ImageView image;
    @BindView(R.id.article_date)TextView date;
    @BindView(R.id.article_description)TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("idArticle");
        Article article = SQLite.select()
                .from(Article.class)
                .where(Article_Table.id.eq(id))
                .querySingle();

        title.setText(article.getTitle());
        Picasso.with(getApplicationContext()).load(article.getImgLink()).into(image);
        date.setText(article.getDate());
        description.setText(article.getDescription());
    }
}
