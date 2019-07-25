package com.lvshihao.service;

import com.lvshihao.dao.UserMapper;
import com.lvshihao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvshihao
 * @Date: $ $
 * @Description:
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findByName(String uname){
       return  userMapper.findByName(uname);
    }
    public User findById(Integer id){
        return  userMapper.findById(id);
    }
}
