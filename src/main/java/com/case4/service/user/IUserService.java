package com.case4.service.user;

import com.case4.model.entity.User;
import com.case4.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUserName(String username);
}
