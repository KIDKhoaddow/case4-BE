package com.case4.controller;

import com.case4.model.dto.PictureForm;
import com.case4.model.entity.blog.Blog;
import com.case4.model.entity.blog.BlogStatus;
import com.case4.model.entity.user.UserInfo;
import com.case4.service.blog.IBlogService;
import com.case4.service.blogStautus.IBlogStatusService;
import com.case4.service.user.UserService;
import com.case4.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogStatusService blogStatusService;
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping("/{idBlog}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long idBlog) {
        Optional<Blog> blog = blogService.findById(idBlog);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @PostMapping("/create/{idUserInfo}")
    public ResponseEntity<Blog> createBlog(@PathVariable Long idUserInfo, @RequestBody Blog blog
            , @ModelAttribute PictureForm pictureForm) {


        Optional<UserInfo> userInfo = userInfoService.findById(idUserInfo);
        if (!userInfo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String image="";
        try {
            MultipartFile multipartFile = pictureForm.getPicture();
            image = multipartFile.getOriginalFilename();
            FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadPath + image));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        localDate.format(fmt1);
        String userRegisDate = String.valueOf(localDate);
        blog.setCreateAt(userRegisDate);

//        blog.setPicture(image);

        BlogStatus blogStatus = new BlogStatus();
        blogStatusService.save(blogStatus);
        blog.setBlogStatus(blogStatus);

        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/update/{idUserInfo}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long idUserInfo, @RequestBody Blog blog
            , @ModelAttribute PictureForm pictureForm) {

        Optional<UserInfo> userInfo = userInfoService.findById(idUserInfo);
        if (!userInfo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MultipartFile multipartFile = pictureForm.getPicture();
        String image = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadPath + image));
        } catch (IOException e) {
            image = blog.getPicture();
            e.printStackTrace();
        }

        blog.setPicture(image);
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idBlog}")
    public ResponseEntity<UserInfo> deleteUserInfo(@PathVariable Long idBlog) {
        blogService.removeById(idBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
