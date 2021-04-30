package com.example.service;

import com.example.entity.UserInfo;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:41
 * @version: 1.0
 */
public interface UserService {
    UserInfo findByUsername(String userName);
}
