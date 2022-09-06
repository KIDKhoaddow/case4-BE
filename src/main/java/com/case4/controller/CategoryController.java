package com.case4.controller;

import com.case4.model.entity.classify.Category;
import com.case4.service.category.ICategorySV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ICategorySV categorySV;


    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> getCategory(@PathVariable Long idCategory){
        Optional<Category> category=categorySV.findById(idCategory);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<Category> createCategory(@RequestBody Category category){
        categorySV.save(category);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Category> updateCategory(@RequestBody Category category){
        categorySV.save(category);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{idCategory}")
    public  ResponseEntity<Boolean> deleteCategory(@PathVariable Long idCategory){
        categorySV.removeById(idCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
