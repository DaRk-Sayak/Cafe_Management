package com.cafe_management.Cafe_management.JWT;

import com.cafe_management.Cafe_management.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    private com.cafe_management.Cafe_management.Model.User userDetails;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        userDetails=userRepo.findByEmailId(email);
        if(!Objects.isNull(userDetails))
            return new User(userDetails.getEmail(),userDetails.getPassword(),new ArrayList<>());
        else
            throw new UsernameNotFoundException("User not found");
    }

    public com.cafe_management.Cafe_management.Model.User getUserDetails(){
        return userDetails;
    }
}
