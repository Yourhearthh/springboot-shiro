package com.example.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:41
 * @version: 1.0
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    /**
     * 用户查询;
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//访问的权限
    public String userList(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//新增的权限
    public String userAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//删除的权限
    public String userDel() {
        return "userInfoDel";
    }


    }
