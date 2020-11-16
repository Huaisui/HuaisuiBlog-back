package com.huaisui.service;

import java.util.List;

public interface IArticleInfoService {
    List getArticlesInfo(int start, int end);
    int getArticleCounts();
    boolean addArticle(String article_id, String article_title, String post_date, String author);
}
