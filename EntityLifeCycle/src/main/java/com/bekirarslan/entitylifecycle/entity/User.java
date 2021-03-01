package com.bekirarslan.entitylifecycle.entity;


import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

/*
    Requirements by Jpa specification
        - Annotated with @Entity
        - Public or protected no-argument constructor
        - Top level class
        - Not final
        -Has an identifier


 */


@Entity
@Data
public class User {
    //log trail
    private static Log log = LogFactory.getLog(User.class);

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    @Transient
    private String fullName;


    @PrePersist
    public void logNewUserAttempt() {
        log.info("Attempting to add new user with username: " + userName);
    }

    @PostPersist
    public void logNewUserAdded() {
        log.info("Added user '" + userName + "' with ID: " + id);
    }

    @PreRemove
    public void logUserRemovalAttempt() {
        log.info("Attempting to delete user: " + userName);
    }

    @PostRemove
    public void logUserRemoval() {
        log.info("Deleted user: " + userName);
    }

    @PreUpdate
    public void logUserUpdateAttempt() {
        log.info("Attempting to update user: " + userName);
    }

    @PostUpdate
    public void logUserUpdate() {
        log.info("Updated user: " + userName);
    }

    @PostLoad
    public void logUserLoad() {
        fullName = firstName + " " + lastName;
    }
}
