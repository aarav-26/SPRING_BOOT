package com.meeting.meeting.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")
public class Users {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name="user_name",length = 60)
    private String userName;

    @Column(name = "email",length = 80)
    private String email;

    @Column(name = "new_password",length=20)
    private String newPassword;

    @Column(name = "confirm_password",length=20)
    private String confirmPassword;

    @Column(name = "date_of_birth",length =10 )
    private String DateOfBirth;

    @Column(name = "city",length=40)
    private String city;

    @Column(name = "state" ,length=60)
    private String state;

    @Column(name = "country",length=30)
    private String country;

    public Users(){}

    public Users(String userName, String email, String newPassword, String confirmPassword, String dateOfBirth, String city, String state, String country) {
        this.userName = userName;
        this.email = email;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        DateOfBirth = dateOfBirth;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}