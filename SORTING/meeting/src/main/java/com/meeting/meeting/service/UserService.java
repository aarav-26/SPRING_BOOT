package com.meeting.meeting.service;

import com.meeting.meeting.DTO.UserSaveDTO;
import com.meeting.meeting.entity.Users;
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
