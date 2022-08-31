package com.case4.model.entity.extra;

import com.case4.model.entity.blog.Blog;
import com.case4.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Likies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Blog blog;
}
