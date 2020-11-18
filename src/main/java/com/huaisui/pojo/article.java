package com.huaisui.pojo;


public class article {
    private String article_id;
    private String article_title;
    private String post_date;
    private String author;

    public article(String article_id, String article_title, String post_date, String author) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.post_date = post_date;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }
}
