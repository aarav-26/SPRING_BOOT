package com.meeting.meeting.controller;

import com.meeting.meeting.DTO.UserMeetingDTO;
import com.meeting.meeting.DTO.UserSaveDTO;
import com.meeting.meeting.entity.MeetingDetails;
import com.meeting.meeting.entity.Users;
import com.meeting.meeting.service.MeetingService;
import com.meeting.meeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1/meeting")
public class MeetingController {

    @Autowired
    private UserService userService;

    @Autowired
    private MeetingService meetingService;

    @PostMapping(path = "/add_new_user")
    public ResponseEntity<Users> addUser(@RequestBody UserSaveDTO userSaveDTO)
    {
        Users user;
        user=userService.addNewUser(userSaveDTO);
        return ResponseEntity.status(201).body(user);
    }

    @PostMapping(path = "/add_meeting_details/{userId}")
    public ResponseEntity<MeetingDetails> addMeetingDetails(@PathVariable int userId, @RequestBody MeetingDetails meetingDetails) {
        MeetingDetails savedMeetingDetails = meetingService.addMeetingDetails(userId, meetingDetails);
        return ResponseEntity.status(201).body(savedMeetingDetails);
    }

    @GetMapping(path = "/get_user_list")
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> usersList = userService.getUsersData();
        return ResponseEntity.ok(usersList);
    }
    @GetMapping("/sortbyfield/{field}")
    public ResponseEntity<List<Users>> getbyfield(@PathVariable String field)
    {
        List<Users> usersList = userService.sortByField(field);
        return ResponseEntity.status(200).body(usersList);
    }

    @GetMapping("/get_user_meeting")
    public ResponseEntity<List<UserMeetingDTO>> getAllUsersWithMeetingDetails() {
        List<UserMeetingDTO> userMeetingDTOs = userService.getAllUsersWithMeetingDetailsDTO();

        return ResponseEntity.ok(userMeetingDTOs);
    }

    @PutMapping("/update_user/{userId}")
    public ResponseEntity<Users> update(@PathVariable Integer userId, @RequestBody Users users)
    {
        Users users1 = userService.updateUser(userId,users);
        if(users1 == null)
            return ResponseEntity.status(404).build();
        return ResponseEntity.ok(users1);
    }

    @DeleteMapping("/delete_user/{userId}")
    public ResponseEntity<String> deleteuser(@PathVariable Integer userId)
    {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).body("Deleted Successfully");
    }

    //HTML FORMAT//
    @GetMapping(path    = "/get_user_list/html")
    public String getUsersHtml(Model model) {
        List<Users> usersList = userService.getUsersData();
        model.addAttribute("userList", usersList);
        return "user-list"; // Assuming you have a Thymeleaf template named "user-list.html"
    }

    @GetMapping("/sortbyfield/html/{field}")
    public String getbysortname(@PathVariable String field, Model model)
    {
        List<Users> sortedUsers = userService.sortByField(field);
        model.addAttribute("userList",sortedUsers);
        return "user-list";
    }

    @GetMapping("/get_user_meeting/html")
    public String getAllUsersWithMeetingDetails(Model model) {
        List<UserMeetingDTO> userMeetingDTOs = userService.getAllUsersWithMeetingDetailsDTO();
        model.addAttribute("userMeetingDTOs", userMeetingDTOs);
        return "user-meeting";
    }


}
