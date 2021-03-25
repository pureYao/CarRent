package com.car.controller;

import com.car.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //Controller层调用Service层
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    //根据username查询管理员
    @RequestMapping("/getAdmin")
    public String list(Model model){
        adminService.getAdmin("13648859657");

        return "getAdmin";
    }
}
