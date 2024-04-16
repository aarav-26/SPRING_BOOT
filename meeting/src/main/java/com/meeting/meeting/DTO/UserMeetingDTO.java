package com.meeting.meeting.DTO;

import java.util.List;

public class UserMeetingDTO {

    private int userId;
    private String userName;
    private String dateOfBirth;
    private String city;
    private List<MeetingDetailsDTO> meetings;

    // Constructor, getters, and setters

    public UserMeetingDTO(int userId, String userName, String dateOfBirth, String city, List<MeetingDetailsDTO> meetings) {
        this.userId = userId;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.meetings = meetings;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<MeetingDetailsDTO> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<MeetingDetailsDTO> meetings) {
        this.meetings = meetings;
    }
}
