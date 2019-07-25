package com.lvshihao.dao;

import com.lvshihao.entity.User;

public interface UserMapper {
    User findByName(String name);
    User findById(Integer id);
}
