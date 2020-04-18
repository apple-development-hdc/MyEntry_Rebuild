package com.myentry.MyEntry.services;


import com.myentry.MyEntry.domain.User;
import com.myentry.MyEntry.dto.UserDto;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * Author :SAURAV ROY
 */
@Service
public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
