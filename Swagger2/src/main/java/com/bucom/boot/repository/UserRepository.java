package com.bucom.boot.repository;

import com.bucom.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserName(String UserName);

}
