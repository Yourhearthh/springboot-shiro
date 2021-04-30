package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:40
 * @version: 1.0
 */
@Controller
public class LogoutController {
    @GetMapping(value = "/logout")
    public void logout(HttpServletResponse response) throws IOException {
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.logout();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/login");
    }
}
