package com.case4.controller;

import com.case4.model.entity.blog.Blog;
import com.case4.model.entity.classify.Category;
import com.case4.model.entity.extra.Like;
import com.case4.service.blog.IBlogService;
import com.case4.service.category.ICategorySV;
import com.case4.service.like.ILikeService;
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
    @Autowired
    private ILikeService likeService;
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

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<Category> getCategory(@PathVariable Long idCategory){
        Optional<Category> category=categorySV.findById(idCategory);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.get(),HttpStatus.OK);
    }
    @GetMapping("/blog/{idBlog}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long idBlog) {
        Optional<Blog> blog = blogService.findById(idBlog);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
    @GetMapping("/countLike/{idBlog}")
    public  ResponseEntity<?> countLike(@PathVariable Long idBlog){
        List<Like> likeList=likeService.findAllByBlogId(idBlog);
        return new ResponseEntity<>(likeList,HttpStatus.OK);
    }
}
