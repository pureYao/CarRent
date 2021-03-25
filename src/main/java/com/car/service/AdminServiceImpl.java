package com.car.service;

import com.car.dao.AdminMapper;
import com.car.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    //Service层调Dao层 组合Dao层
    @Autowired
    private AdminMapper adminMapper;
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public Admin getAdmin(String phone_num) {
        return adminMapper.getAdmin(phone_num);
    }



}
