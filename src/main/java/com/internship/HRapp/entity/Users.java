package com.internship.HRapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Users {

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate DOB;
    private Integer leaveDays;

    @Transient
    private Integer age;

    public Users() {
    }

    public Users(Long userId,
                 String username,
                 String password,
                 String firstName,
                 String lastName,
                 String email,
                 LocalDate DOB,
                 Integer leaveDays) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
        this.leaveDays = leaveDays;
    }

    public Users(String username,
                 String password,
                 String firstName,
                 String lastName,
                 String email,
                 LocalDate DOB,
                 Integer leaveDays) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
        this.leaveDays = leaveDays;
    }

    public Integer getAge(){
        return Period.between(this.DOB, LocalDate.now()).getYears();
    }
    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", DOB=" + DOB +
                ", leaveDays=" + leaveDays +
                '}';
    }

}
