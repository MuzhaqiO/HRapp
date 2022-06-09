package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.dayOffDTO.StatusDTO;
import com.internship.HRapp.dto.dayOffDTO.UserDayOffDTO;
import com.internship.HRapp.dto.dayOffDTO.CreateDayOffDTO;
import com.internship.HRapp.entity.DayOff;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.enums.DayOffPermission;
import com.internship.HRapp.enums.DayOffStatus;
import com.internship.HRapp.mapper.DayOffMapper;
import com.internship.HRapp.repository.DayOffRepository;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@EnableScheduling

public class DayOffServiceImpl implements DayOffService {

    private final DayOffRepository dayOffRepo;

    private final DayOffMapper dayOffMapper;

    private final UserRepo userRepo;


    @Override
    public void updateDayOffRequest(StatusDTO status) {
        DayOff thisDayOff = dayOffRepo.findDayOffByDayOffId(status.getDayOffId());
        User approver = userRepo.findUserByUserId(status.getUserId());
        thisDayOff.setRequestStatus(status.getRequestStatus());
        thisDayOff.setIdOfApprove(approver.getUserId());
        thisDayOff.setRejectReason(status.getRejectReason());
        List<User> users = userRepo.findAllByDaysOffDayOffId(status.getDayOffId());
        if (thisDayOff.getPermissionType().equals(DayOffPermission.DEFAULT)
                && thisDayOff.getRequestStatus().equals(DayOffStatus.APPROVED)) {
            for (var user2 : users) {
                user2.setLeaveDaysLeft(user2.getLeaveDaysLeft() - thisDayOff.getDayOffAmount());
                userRepo.save(user2);
            }
        }else{
            throw new IllegalStateException("This request was rejected");
        }
        dayOffRepo.save(thisDayOff);
    }

    @Override
//    @Scheduled(initialDelay = 60 * 60, fixedDelay = 60 * 60)
//    public void updateLeaveDaysLeft() {
//        var users = userRepo.findAll();
//        for (var user : users) {
//            long daysBetween = DAYS.between(user.getStartingDay(), LocalDate.now());
//            if (daysBetween % 30 == 0) {
//                user.setLeaveDaysLeft(user.getLeaveDaysLeft() + 1.7);
//                userRepo.save(user);
//            } else if (daysBetween % 30 != 0) {
//                System.out.println("No vacay");
//            }
//        }
//    }

    public void deleteDayOff(UUID dayOffId) {
        boolean exists = dayOffRepo.existsById(dayOffId);
        if (!exists) {
            throw new IllegalStateException(
                    "dayOff with id " + dayOffId + " does not exist");
        }
        dayOffRepo.deleteById(dayOffId);
    }

    @Override
    public List<UserDayOffDTO> getUserDayOff(UUID userId) {
        return dayOffMapper.toDtos(dayOffRepo.getByUsersUserId(userId));
    }

    public UserDayOffDTO placeDayOffRequest(CreateDayOffDTO requestDTO) {
        DayOff created = dayOffRepo.save(dayOffMapper.toEntity(requestDTO));
        List<User> users = userRepo.findAllByDaysOffDayOffId(created.getDayOffId());
        {
            for (var user1 : users) {
                if (requestDTO.getDayOffAmount() > user1.getLeaveDaysLeft()) {
                    throw new RuntimeException("Can't make request, not enough days left");
                }
            }
        }

        return dayOffMapper.toDto(created);
    }


}
