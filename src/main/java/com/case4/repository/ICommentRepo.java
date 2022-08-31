package com.case4.repository;

import com.case4.model.entity.extra.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Long> {
}
