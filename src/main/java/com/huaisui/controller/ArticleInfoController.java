package com.huaisui.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaisui.pojo.Article;
import com.huaisui.service.ArticlesInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ArticleInfoController {
    ArticlesInfoService service = new ArticlesInfoService();
    final int n_articles_per_page = 5;
    @GetMapping("/getArticlesInfo")
    @ResponseBody
    public Object getArticlesInfo(@RequestParam(value = "page",required = false,defaultValue = "1") int page){
        int article_count = service.getArticleCounts();
        int start=0, end=0;
        if ((page-1)*n_articles_per_page < article_count){   //如果文章数量足够
            if (page*n_articles_per_page > article_count) {
                start = (page-1)*n_articles_per_page;
                end = article_count;
            }else {
                start = (page-1)*n_articles_per_page;
                end = page*n_articles_per_page;
            }
            System.out.println("getArticlesInfo enough");
        }else {
            //404
            System.out.println("getArticlesInfo not enough");
            return "redirect:/";
        }
        System.out.println("page = "+page+", start = "+start+", end = "+end);
        List<Article> articles = service.getArticlesInfo(start,end);
        return articles;
    }

    @GetMapping("/getarticle")
    public @ResponseBody JSONObject getArticle(@RequestParam(value = "id") String id){
        String content = null;
        File file = new File("C:\\Users\\49868\\Desktop\\Upload\\"+id+".md");
        if (!file.exists()){
            System.out.println("file dont exists!");

        }
        try{
            Stream<String> lines = Files.lines(Paths.get("C:\\Users\\49868\\Desktop\\Upload\\"+id+".md"));
            content = lines.collect(Collectors.joining(System.lineSeparator()));
            String title = id;
            JSONObject object = new JSONObject();
            object.put("title",title);
            object.put("content",content);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no");
        }
        System.out.println("?");
        return null;
    }
}
