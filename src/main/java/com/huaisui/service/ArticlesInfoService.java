package com.huaisui.service;

import com.huaisui.dao.ArticleMapper;
import com.huaisui.pojo.article;
import com.huaisui.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ArticlesInfoService implements IArticleInfoService{
    @Override
    public List getArticlesInfo(int start,int end) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<article> articles = null;
        try{
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            articles = mapper.getArticles(start,end);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
            return articles;
        }
    }

    @Override
    public int getArticleCounts() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int ans = 0;
        try{
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            ans = mapper.getArticleCounts();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
            return ans;
        }
    }

    @Override
    public boolean addArticle(String article_id, String article_title, String post_date, String author) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
            mapper.addArticle(article_id,article_title,post_date,author);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
        return true;
    }
}
