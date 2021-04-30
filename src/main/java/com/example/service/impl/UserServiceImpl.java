package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:42
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserInfo findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}
