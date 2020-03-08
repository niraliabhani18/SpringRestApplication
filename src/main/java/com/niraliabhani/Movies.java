package com.niraliabhani;

import javax.persistence.*;

@Entity @Table(name = "moviesList")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;

    public Movies() {}

    public Movies(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public Movies(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}' + '\n';
    }
}
