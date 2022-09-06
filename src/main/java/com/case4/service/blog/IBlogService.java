package com.case4.service.blog;

import com.case4.model.entity.blog.Blog;
import com.case4.service.IGeneralService;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findAllByCategory_Name(String categoryName);
}
