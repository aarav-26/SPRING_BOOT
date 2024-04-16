package com.meeting.meeting.service;

import com.meeting.meeting.DTO.MeetingDetailsDTO;
import com.meeting.meeting.DTO.UserMeetingDTO;
import com.meeting.meeting.DTO.UserSaveDTO;
import com.meeting.meeting.entity.MeetingDetails;
import com.meeting.meeting.entity.Users;
import com.meeting.meeting.repository.MeetingRepo;
import com.meeting.meeting.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MeetingRepo meetingRepo;

    public Users addNewUser(UserSaveDTO userSaveDTO)
    {
        Users user=new Users(userSaveDTO.getUserName(),
                userSaveDTO.getEmail(),userSaveDTO.getNewPassword(),userSaveDTO.getConfirmPassword(),userSaveDTO.getDateOfBirth(),userSaveDTO.getCity(),userSaveDTO.getState(),userSaveDTO.getCountry());

        userRepo.save(user);

        return user;
    }

    public List<Users> getUsersData()
    {
        List<Users> datalist;
        datalist = userRepo.findAll();
        return datalist;
    }

    public Users updateUser(Integer userId, Users users)
    {
        Optional<Users> olduser = userRepo.findById(userId);

        if(olduser.isEmpty())
            return null;

        Users users3 = olduser.get();

        users3.setUserName(users.getUserName());
        users3.setEmail(users.getEmail());
        users3.setNewPassword(users.getNewPassword());
        users3.setConfirmPassword(users.getConfirmPassword());

        userRepo.save(users3);

        return users3;
    }

    public List<UserMeetingDTO> getAllUsersWithMeetingDetailsDTO() {
        List<Users> users = userRepo.findAll();
        List<UserMeetingDTO> userMeetingDTOs = new ArrayList<>();

        for (Users user : users) {
            List<MeetingDetailsDTO> meetingDetailsDTOs = new ArrayList<>();
            List<MeetingDetails> meetingDetails = meetingRepo.findByUser(user);
            for (MeetingDetails meetingDetail : meetingDetails) {
                MeetingDetailsDTO meetingDetailsDTO = new MeetingDetailsDTO(
                        meetingDetail.getTitle(),
                        meetingDetail.getDescription(),
                        meetingDetail.getDate(),
                        meetingDetail.getTime()
                );
                meetingDetailsDTOs.add(meetingDetailsDTO);
            }

            UserMeetingDTO userMeetingDTO = new UserMeetingDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getDateOfBirth(),
                    user.getCity(),
                    meetingDetailsDTOs
            );
            userMeetingDTOs.add(userMeetingDTO);
        }

        return userMeetingDTOs;
    }

    public void deleteUser(Integer userId) {

        Optional<Users> deleteUser = userRepo.findById(userId);
        if(deleteUser.isEmpty())
            return ;
        userRepo.deleteById(userId);
    }

    public List<Users> sortByField(String field) {

        return userRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }
}
