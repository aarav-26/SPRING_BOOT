package com.meeting.meeting.repository;

import com.meeting.meeting.entity.MeetingDetails;
import com.meeting.meeting.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<MeetingDetails,Integer> {

    List<MeetingDetails> findByUser(Users user);
}
