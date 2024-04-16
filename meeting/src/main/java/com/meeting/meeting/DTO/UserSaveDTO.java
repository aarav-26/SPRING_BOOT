package com.meeting.meeting.DTO;

public class UserSaveDTO {

    private String userName;
    private String email;
    private String newPassword;
    private String confirmPassword;
    private String dateOfBirth;
    private String city;
    private String state;
    private String country;

    public UserSaveDTO(String userName, String email, String newPassword, String confirmPassword, String dateOfBirth, String city, String state, String country) {
        this.userName = userName;
        this.email = email;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.state = state;
        this.country = country;
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
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirth = dateOfBirth;
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
