package com.case4.controller;

import com.case4.model.entity.User;
import com.case4.model.entity.UserInfo;
import com.case4.service.user.UserService;
import com.case4.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminViewController {
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserInfo>> getListUserInfo(){

        return new ResponseEntity<List<UserInfo>>(userInfoService.findAll(), HttpStatus.OK);
    }

}
