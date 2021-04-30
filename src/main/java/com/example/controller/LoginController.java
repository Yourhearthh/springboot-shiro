package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:40
 * @version: 1.0
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String toLogin(Map<String, Object> map) {
        Subject current = SecurityUtils.getSubject();
        String msg = (String) current.getSession().getAttribute("msg");
        map.put("msg", msg);
        return "login";
    }

    @PostMapping("/login")
    public void login(HttpServletResponse resp, Map<String, Object> map,
                      @RequestParam(value = "username") String userName,
                      @RequestParam(value = "password") String password) throws Exception {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.getSession().setAttribute("username", userName);
            currentUser.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("测试" + e.getMessage() + "账户");
            currentUser.getSession().setAttribute("msg", "账号不存在");
        } catch (IncorrectCredentialsException e) {
            System.out.println("测试" + e.getMessage() + "密码");
            currentUser.getSession().setAttribute("msg", "密码不正确");
        }
        resp.sendRedirect("/index");
    }


    @GetMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }
}
