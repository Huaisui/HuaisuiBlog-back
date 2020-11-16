package com.huaisui.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaisui.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/loginform")
    public void login(@RequestBody JSONObject form, HttpServletRequest request, HttpServletResponse response){
        String userid = form.getString("userid");
        String password = form.getString("password");
        System.out.println(userid);
        System.out.println(password);
        UserService service = new UserService();
        if (service.ifLoginSuccess(userid,password)){
            HttpSession session = request.getSession();
            session.setAttribute("userid",userid);
            response.setHeader("redirect","redirect");
            response.setHeader("redirectPath","http://localhost:8080/upload");
        }else {
            System.out.println("error");
        }
    }
//    @RequestParam(name = "userid") String userid,
//    @RequestParam(name = "password") String password
}
