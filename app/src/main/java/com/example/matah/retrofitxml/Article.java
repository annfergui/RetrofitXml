package com.example.matah.retrofitxml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)

/**
 * Created by matah on 07/06/2017.
 */

public class Article {
    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
