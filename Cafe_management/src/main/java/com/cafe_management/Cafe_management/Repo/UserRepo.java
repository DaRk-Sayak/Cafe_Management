package com.cafe_management.Cafe_management.Repo;

import com.cafe_management.Cafe_management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmailId(@Param("email") String email);
}
