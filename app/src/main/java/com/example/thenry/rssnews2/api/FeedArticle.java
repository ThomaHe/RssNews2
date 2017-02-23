package com.example.thenry.rssnews2.api;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


/**
 * Created by thenry on 22/02/2017.
 */
@Root(name = "item", strict = false)
public class FeedArticle {

    @Element(name = "title" )
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "pubDate")
    private String date;

    @Element(name = "enclosure")
    private Enclosure enclosure;

    private static class Enclosure {
        @Attribute(name = "url")
        private String url;

        @Attribute(name = "type")
        private String type;

        @Attribute(name = "length")
        private int length;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getImage()
    {
        return enclosure.url;
    }

    public FeedArticle(String title, String description, String date, Enclosure enclosure) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.enclosure = enclosure;
    }

    public FeedArticle() {
    }
}
