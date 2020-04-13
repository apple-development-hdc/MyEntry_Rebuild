package com.myentry.MyEntry.repository;

import com.myentry.MyEntry.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author :SAURAV ROY
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

}
