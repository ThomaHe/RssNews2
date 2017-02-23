package com.example.thenry.rssnews2.api;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by thenry on 22/02/2017.
 */

@Root(name="rss", strict=false)
public class RssFeed implements Serializable{

    @Element(name="channel")
    private FeedChannel channel;

    public FeedChannel getChannel() {
        return channel;
    }

    public void setChannel(FeedChannel channel) {
        this.channel = channel;
    }

    public RssFeed(FeedChannel channel) {
        this.channel = channel;
    }

    public RssFeed() {
    }
}