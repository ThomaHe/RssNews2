package com.example.thenry.rssnews2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by thenry on 22/02/2017.
 */

@Root(name="rss", strict=false)
public class RssFeed {

    @Element(name="title")
    @Path("channel")
    private String channelTitle;

    @ElementList(name="item", inline=true)
    @Path("channel")
    private List<FeedArticle> articleList;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public List<FeedArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<FeedArticle> articleList) {
        this.articleList = articleList;
    }


}