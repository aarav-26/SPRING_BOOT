package com.meeting.meeting.service;

import com.meeting.meeting.DTO.MeetingDetailsDTO;
import com.meeting.meeting.DTO.UserMeetingDTO;
import com.meeting.meeting.entity.MeetingDetails;
import com.meeting.meeting.entity.Users;
import com.meeting.meeting.repository.MeetingRepo;
import com.meeting.meeting.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MeetingService {

    @Autowired
    private MeetingRepo meetingRepo;

    @Autowired
    private UserRepo userRepo;

    public MeetingDetails addMeetingDetails(int userId, MeetingDetails meetingDetails) {
        Optional<Users> optionalUser = userRepo.findById(userId);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            meetingDetails.setUser(user);
        }
        return meetingRepo.save(meetingDetails);
    }
}
