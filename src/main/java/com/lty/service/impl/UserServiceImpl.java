package com.lty.service.impl;

import com.lty.mapper.UserMapper;
import com.lty.model.Area;
import com.lty.model.City;
import com.lty.model.Province;
import com.lty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

}
