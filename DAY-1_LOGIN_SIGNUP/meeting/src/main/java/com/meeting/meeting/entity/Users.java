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

    public Users() {
    }

    public Users(String userName, String email, String newPassword, String confirmPassword) {
        this.userName = userName;
        this.email = email;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
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
}
