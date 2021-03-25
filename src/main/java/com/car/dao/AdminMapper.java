package com.car.dao;

import com.car.pojo.Admin;

public interface AdminMapper {
    //查询管理员
    Admin getAdmin(String phone_num);

}
