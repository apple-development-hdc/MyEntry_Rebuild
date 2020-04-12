package com.myentry.MyEntry.Services;

import com.myentry.MyEntry.Constants.CommonConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.myentry.MyEntry.DTO.Role;
import com.myentry.MyEntry.DTO.User;
import com.myentry.MyEntry.DTO.UserDto;
import com.myentry.MyEntry.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

/**
 * Author :SAURAV ROY
 */
@Service
public class JwtUserDetailsService implements UserDetailsService, UserService  {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    /**
     * List of Users in DB
     * @return List<User>
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    /**
     *
     * @param id {@link long}
     */
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    /**
     *
     * @param username {@link String}
     * @return User
     */
    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Return By Id
     * @param id {@link Long}
     * @return  User
     */
    @Override
    public User findById(Long id) {
        return  userRepository.findById(id).get();
    }

    /**
     * Overriding the  save method to store Password in BCryptEncoder format
     * @param user {@link UserDto}
     * @return User
     */
    @Override
    public User save(UserDto user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }
}

