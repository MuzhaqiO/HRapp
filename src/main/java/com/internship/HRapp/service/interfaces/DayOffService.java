package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.dayOffDTO.CreateDayOffDTO;
import com.internship.HRapp.dto.dayOffDTO.StatusDTO;
import com.internship.HRapp.dto.dayOffDTO.UserDayOffDTO;

import java.util.List;
import java.util.UUID;

public interface DayOffService {

   // UserDayOffDTO getUserDayOff(UUID userId);

    UserDayOffDTO placeDayOffRequest(CreateDayOffDTO requestDTO);

    void deleteDayOff(UUID dayOffId);

    void updateDayOffRequest(StatusDTO status);
    List<UserDayOffDTO> getUserDayOff(UUID userId);

    //void updateLeaveDaysLeft();



}
