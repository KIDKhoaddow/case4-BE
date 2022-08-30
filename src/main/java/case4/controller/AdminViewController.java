package case4.controller;

import case4.model.entity.Blog;
import case4.model.entity.Status;
import case4.model.entity.UserInfo;
import case4.service.user.UserService;
import case4.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminViewController {
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getListUserInfo(){
        return new ResponseEntity<>(userInfoService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/statues")
    public ResponseEntity<Status[]> getListStatus(){
        return  new ResponseEntity<>(Status.values(),HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public  ResponseEntity<List<Blog>> getListBlogs(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
