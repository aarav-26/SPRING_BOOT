package com.meeting.meeting.controller;

import com.meeting.meeting.DTO.UserSaveDTO;
import com.meeting.meeting.entity.Users;
import com.meeting.meeting.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meeting")
public class MeetingController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add_new_user")
    public String addUser(@RequestBody UserSaveDTO userSaveDTO)
    {
        String user;
        user=userService.addNewUser(userSaveDTO);
        return user;
    }

    @GetMapping(path = "/get_user_list")
    public List<Users> getUsers()
    {
        List<Users> usersList;
        usersList = userService.getUsersData();
        return usersList;
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
}
