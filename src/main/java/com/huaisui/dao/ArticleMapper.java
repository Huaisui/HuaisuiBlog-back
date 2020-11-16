package com.huaisui.dao;

import com.huaisui.pojo.Article;

import java.util.List;

public interface ArticleMapper {
    List<Article> getArticles(int start,int end);
    Article getArticle(String id);
    int getArticleCounts();
    boolean addArticle(String article_id,String article_title,String post_date,String author);
}
