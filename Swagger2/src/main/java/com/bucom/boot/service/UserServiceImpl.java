package com.bucom.boot.service;

import com.bucom.boot.model.User;
import com.bucom.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public User queryLogin(String UserName){

        return userRepository.findByUserName(UserName);
    }

}
