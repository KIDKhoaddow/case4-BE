package com.case4.repository;

import com.case4.model.entity.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStatusRepository extends JpaRepository<UserStatus,Long> {
}
