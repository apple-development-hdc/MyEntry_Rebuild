package com.myentry.MyEntry.domain;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

import static com.myentry.MyEntry.constants.CommonConstants.LOGIN_DATE;
import static com.myentry.MyEntry.constants.CommonConstants.LOGOUT_DATE;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Column(name = LOGIN_DATE)
    private LocalDateTime loginDate;

    @Column(name = LOGOUT_DATE)
    private LocalDateTime logoutDate;


    public void loginDateSetter() {
        this.loginDate = LocalDateTime.now();
    }
    public void logoutDateSetter() {
        this.loginDate = LocalDateTime.now();
    }

}