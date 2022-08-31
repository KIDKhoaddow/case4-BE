package com.case4.service.blog;

import com.case4.model.entity.blog.Blog;
import com.case4.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepo iBlogRepo;
    @Override
    public List<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepo.save(blog);
    }

    @Override
    public void removeById(Long id) {
    iBlogRepo.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogRepo.findById(id);
    }
}
