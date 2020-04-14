package com.myentry.MyEntry.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

import static com.myentry.MyEntry.constants.CommonConstants.*;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column(name = CREATED_DATE)
    private LocalDateTime createDate;

    @Column(name = MODIFIED_DATE)
    private LocalDateTime modifiedDate;

    @Column(name = CREATED_BY)
    private String createdBy;

    @Column(name = MODIFIED_BY)
    private String modifiedBy;

    /**
     * Stores created date in DB for new record
     */
    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        this.createdBy = "SYS_ADMIN";
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
        this.modifiedBy = "SYS_ADMIN";
    }
}

