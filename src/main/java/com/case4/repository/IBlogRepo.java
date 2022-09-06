package com.case4.repository;

import com.case4.model.entity.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepo extends JpaRepository<Blog,Long> {

    List<Blog> findAllByCategory_Name(String categoryName);
}
