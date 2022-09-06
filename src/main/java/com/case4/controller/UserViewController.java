package com.case4.controller;

import com.case4.model.entity.blog.Blog;
import com.case4.model.entity.classify.Category;
import com.case4.service.blog.IBlogService;
import com.case4.service.category.ICategorySV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/userView")
public class UserViewController {
    @Autowired
    private ICategorySV categorySV;

    @Autowired
    private IBlogService blogService;


    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> getListCategory() {
        return new ResponseEntity<>(categorySV.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listBlogByCategoryName/{categoryName}")
    public ResponseEntity<List<Blog>> getListBlogByCategoryName(@PathVariable Optional<String> categoryName) {
        if (!categoryName.isPresent()) {
            if (!categorySV.findByName(categoryName.get()).isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(blogService.findAllByCategory_Name(categoryName.get()), HttpStatus.OK);
    }

}
