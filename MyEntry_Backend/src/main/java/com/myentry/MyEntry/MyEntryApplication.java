package com.myentry.MyEntry;

import com.myentry.MyEntry.constants.CommonConstants;
import com.myentry.MyEntry.domain.Role;
import com.myentry.MyEntry.domain.User;
import com.myentry.MyEntry.domain.UserRole;
import com.myentry.MyEntry.repository.RoleRepository;
import com.myentry.MyEntry.repository.UserRepository;
import com.myentry.MyEntry.repository.UserRoleRepository;
import com.myentry.MyEntry.services.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author :SAURAV ROY
 */
@SpringBootApplication
@EnableCaching
public class MyEntryApplication implements CommandLineRunner, InitializerService {

    public static void main(String[] args) {
        SpringApplication.run(MyEntryApplication.class, args);
    }

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {
        saveAdminRole();
        saveUserRole();
        setSuperUserCredentials();
    }


    @Override
    public void saveAdminRole() {
        Role role = new Role();
        role.setId(4);
        role.setDescription("Admin Role");
        role.setName("ADMIN");
        roleRepository.save(role);
    }

    @Override
    public void saveUserRole() {
        Role role = new Role();
        role.setId(5);
        role.setDescription("User Role");
        role.setName("USER");
        roleRepository.save(role);
    }

    @Override
    public void setSuperUserCredentials() {
        User user = new User();
        user.setUsername(CommonConstants.SUPER_USER_USERNAME);
        user.setPassword(bcryptEncoder.encode(CommonConstants.SUPER_USER_PASSWORD));
        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(1);
        userRole.setRoleId(4);
        userRoleRepository.save(userRole);
    }
}
