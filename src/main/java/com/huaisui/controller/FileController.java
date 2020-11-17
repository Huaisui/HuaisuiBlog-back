package com.huaisui.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaisui.service.ArticlesInfoService;
import com.huaisui.utils.MyBlogUtils;
import com.huaisui.utils.myUrlUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileController {
    //上传图片
    @PostMapping("/postpic")
    public JSONObject postPic(
            @RequestParam(value = "editormd-image-file", required = false) MultipartFile file,
            HttpServletRequest request) throws URISyntaxException {
        String FileName = System.currentTimeMillis() + file.getOriginalFilename();
        String fileUrl = MyBlogUtils.getHost(new URI(request.getRequestURL() + "")) + "/images/" + FileName;
        JSONObject jsonObject = new JSONObject();
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(myUrlUtils.UPLOADED_FOLDER+FileName);
            Files.write(path, bytes);
        } catch (Exception e) {
            jsonObject.put("success", 0);
            jsonObject.put("message", "上传失败！");
            e.printStackTrace();
        } finally {
            jsonObject.put("success", 1);
            jsonObject.put("message", "上传成功");
            jsonObject.put("url", fileUrl);
        }
        return jsonObject;
    }

    //上传文章和标题
    @PostMapping("/postfile")
    public void postfile(@RequestBody JSONObject object){
        System.out.println(object);
        String content = object.getString("content");
        String title = object.getString("title");
        try{
            byte[] bytes = content.getBytes();
            Path path = Paths.get(myUrlUtils.UPLOADED_FOLDER + title + ".md");
            Files.write(path,bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            String article_id = title;
            String pattern = "yyyy-MM-dd HH:mm:ss";
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            String postDate = dateFormat.format(new Date());
//            Article article = new Article(article_id, title, postDate, "TeoHuaisui");
            ArticlesInfoService service = new ArticlesInfoService();
            boolean ans = service.addArticle(article_id, title, postDate, "TeoHuaisui");
            System.out.println(ans);
        }
    }
}
