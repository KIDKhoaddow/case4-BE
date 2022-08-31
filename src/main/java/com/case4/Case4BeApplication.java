package com.case4;


import com.case4.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Case4BeApplication {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(Case4BeApplication.class, args);
    }

}