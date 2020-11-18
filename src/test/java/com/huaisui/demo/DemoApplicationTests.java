package com.huaisui.demo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
//
//    @Test
//    void contextLoads() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        try {
//            //法1:getMapper
//            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
//            mapper.addArticle("title","title_01","2020-11-09 00:00:00","HuaisuiTest");
//            Article article = mapper.getArticle("title");
//            System.out.println(article.getArticle_id());
//            int c = mapper.getArticleCounts();
//            System.out.println(c);
//            List<Article> articles = mapper.getArticles(0,c);
//            for (int i = 0; i < articles.size(); i++){
//                System.out.println(articles.get(i).getArticle_id());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//    }
//
//    @Test
//    void MDtest(){
////        String content = Files.
////        System.out.println(MarkdownUtils.markdownToHtml("## xxx"));
//        try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\49868\\Desktop\\Upload\\title.md"))){
//            String content = lines.collect(Collectors.joining(System.lineSeparator()));
//            System.out.println(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void ServiceTest(){
//        ArticlesInfoService service = new ArticlesInfoService();
//        System.out.println("counts = "+service.getArticleCounts());
//        boolean a = service.addArticle("title","title_01","2020-11-09 00:00:00","HuaisuiTest");
//        System.out.println(a);
//        ArticlesInfoService service2 = new ArticlesInfoService();
//        System.out.println("counts = "+service2.getArticleCounts());
//        List<Article> articles = service2.getArticlesInfo(0, service2.getArticleCounts());
//        for (int i = 0; i < articles.size(); i++){
//            System.out.println(articles.get(i).getArticle_id());
//        }
//    }
//
//    @Test
//    void UserTest(){
//        UserService service = new UserService();
//        System.out.println(service.ifLoginSuccess("H","pwd"));
//    }
//
//    @Test
//    void LoginTest(){
//
//    }
}
