package com.meeting.meeting.service;

import com.meeting.meeting.DTO.UserSaveDTO;
import com.meeting.meeting.entity.Users;
import com.meeting.meeting.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String addNewUser(UserSaveDTO userSaveDTO)
    {
        Users user=new Users(userSaveDTO.getUserName(),
                userSaveDTO.getEmail(),userSaveDTO.getNewPassword(),userSaveDTO.getConfirmPassword());

        userRepo.save(user);

        return user.getUserName();
    }

    public List<Users> getUsersData()
    {
        List<Users> datalist;
        datalist = new ArrayList<Users>(userRepo.findAll());
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

    public void deleteUser(Integer userId) {

        Optional<Users> deleteUser = userRepo.findById(userId);
        if(deleteUser.isEmpty())
            return ;
        userRepo.deleteById(userId);
    }
}
