package com.myentry.MyEntry.domain;
import static com.myentry.MyEntry.constants.CommonConstants.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Author :SAURAV ROY
 */

/**
 * SIGN UP USER
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = LOGIN_DATE, insertable = false, updatable = false)
    private LocalDateTime loginDate;

    @Column(name = LOGOUT_DATE, insertable = false, updatable = false)
    private LocalDateTime logoutDate;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void setLoginDate() {
        this.loginDate = LocalDateTime.now();
    }
    public void logoutDateSetter() {
        this.loginDate = LocalDateTime.now();
    }
}
