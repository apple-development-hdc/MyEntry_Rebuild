package com.myentry.MyEntry.Repository;

import com.myentry.MyEntry.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author :SAURAV ROY
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

}
