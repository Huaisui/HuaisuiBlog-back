package com.huaisui.dao;

import com.huaisui.pojo.article;

import java.util.List;

public interface ArticleMapper {
    List<article> getArticles(int start, int end);
    article getArticle(String id);
    int getArticleCounts();
    boolean addArticle(String article_id,String article_title,String post_date,String author);
}
