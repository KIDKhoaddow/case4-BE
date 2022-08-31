package com.case4.model.entity.blog;

import com.case4.model.entity.classify.Category;
import com.case4.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Category category;
    private String title;
    private  String content;
    private  String picture;
    private  String createAt;
    @ManyToOne
    private User user;

}
