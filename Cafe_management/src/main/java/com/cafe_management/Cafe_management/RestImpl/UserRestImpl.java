package com.cafe_management.Cafe_management.RestImpl;

import com.cafe_management.Cafe_management.Constents.CafeConstants;
import com.cafe_management.Cafe_management.Rest.UserRest;
import com.cafe_management.Cafe_management.Service.UserService;
import com.cafe_management.Cafe_management.Util.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.Something_Went_Wrong,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
