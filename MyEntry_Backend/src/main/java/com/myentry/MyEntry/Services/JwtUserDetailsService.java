package com.myentry.MyEntry.Services;

import com.myentry.MyEntry.Constants.CommonConstants;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    /**
     * fetch username and authenticate using spring security
     * @param username {@link String}
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (CommonConstants.ADMIN_USERNAME.equals(username)) {
            return new User(username, bcryptEncoder.encode(CommonConstants.ADMIN_PASS),
                    new ArrayList<>());
        }
       else if (CommonConstants.USER_USERNAME.equals(username)) {
            return new User(username, bcryptEncoder.encode(CommonConstants.USER_PASS),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }


}
