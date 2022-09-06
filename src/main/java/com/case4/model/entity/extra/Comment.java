package com.case4.model.entity.extra;

import com.case4.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String content;
    private  String createAt;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Comment> commentList ;
}
