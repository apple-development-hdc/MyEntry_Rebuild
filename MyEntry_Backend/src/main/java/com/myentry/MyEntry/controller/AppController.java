package com.myentry.MyEntry.controller;

import com.myentry.MyEntry.constants.APIConstants;
import com.myentry.MyEntry.domain.User;
import com.myentry.MyEntry.dto.UserDto;
import com.myentry.MyEntry.services.JwtUserDetailsService;
import com.myentry.MyEntry.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Author :SAURAV ROY
 */
@Slf4j
@RestController
@CrossOrigin("*")
public class AppController {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private UserService userService;

    /**
     *
     * @return
     */
    @PreAuthorize("hasRole('USER')")
    @GetMapping( "/user/check" )
    public String firstPage() {
        Cache cache = cacheManager.getCache("token");
        assert cache != null;
        return "User ROLE API";
    }
    /**
     *
     * @return List<User>
     */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    /**
     *Register the user
     * @param userDto
     * @return
     */
    @RequestMapping(value = APIConstants.SIGNUP_API,method = RequestMethod.POST)
        public ResponseEntity<?>newUser(@RequestBody UserDto userDto){
        jwtUserDetailsService.save(userDto);
       return ResponseEntity.ok(userDto);
        }

}
