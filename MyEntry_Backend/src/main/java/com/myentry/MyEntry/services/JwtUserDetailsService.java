package com.myentry.MyEntry.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.myentry.MyEntry.domain.UserRole;
import com.myentry.MyEntry.domain.User;
import com.myentry.MyEntry.dto.UserDto;
import com.myentry.MyEntry.repository.UserRepository;
import com.myentry.MyEntry.repository.UserRoleRepository;
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
public class JwtUserDetailsService implements UserDetailsService, com.myentry.MyEntry.services.UserService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

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
        UserRole userRole = new UserRole();
        userRole.setRoleId(5);
        userRoleRepository.save(userRole);
        return userRepository.save(newUser);
    }
}

