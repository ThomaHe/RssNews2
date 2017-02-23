package com.example.thenry.rssnews2.api;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thenry on 23/02/2017.
 */
@Root(name="channel", strict = false)
public class FeedChannel implements Serializable {

    @ElementList(name="item", inline=true)
    private List<FeedArticle> articleList;

    public List<FeedArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<FeedArticle> articleList) {
        this.articleList = articleList;
    }

    public FeedChannel(List<FeedArticle> articleList) {
        this.articleList = articleList;
    }

    public FeedChannel() {
    }
}
