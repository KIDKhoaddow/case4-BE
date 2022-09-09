package com.case4.repository;

import com.case4.model.dto.LikeCount;
import com.case4.model.entity.blog.Blog;
import com.case4.model.entity.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepo extends JpaRepository<Blog,Long> {
    List<Blog> findAllByCategory_Name(String categoryName);
    List<Blog> findAllByUserInfo(UserInfo userInfo);
    @Query(value = "SELECT blogs.id as blogId ,count(likies.blog_id) as countL FROM case4.blogs inner join case4.likies on likies.blog_id = blogs.id group by likies.blog_id  limit 10;", nativeQuery = true)
    List<LikeCount> findCount();


}
