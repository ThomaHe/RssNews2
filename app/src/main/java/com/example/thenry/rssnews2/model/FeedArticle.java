package com.example.thenry.rssnews2.model;

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

    private class Enclosure {
        @Attribute(name = "url")
        private String url;
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

}
