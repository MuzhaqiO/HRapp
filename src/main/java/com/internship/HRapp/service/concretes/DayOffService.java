package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.dayOffDTO.StatusDTO;
import com.internship.HRapp.dto.dayOffDTO.UserDayOffDTO;
import com.internship.HRapp.dto.dayOffDTO.createDayOffDTO;
import com.internship.HRapp.entity.DayOff;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.enums.DayOffStatus;
import com.internship.HRapp.mapper.DayOffMapper;
import com.internship.HRapp.repository.DayOffRepository;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.DayOffServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@EnableScheduling
public class DayOffService implements DayOffServiceInterface {
    private final DayOffRepository dayOffRepo;
    private final DayOffMapper dayOffMapper;
    private final UserRepo userRepo;

    @Override
    public void updateDayOffRequest(UUID dayOffId, StatusDTO status) {
        DayOff thisDayOff = dayOffRepo.getById(dayOffId);
        thisDayOff.setRequestStatus(status.getRequestStatus());
        dayOffRepo.save(thisDayOff);
    }

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

    @Override
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

    @Override
    public UserDayOffDTO placeDayOffRequest(createDayOffDTO requestDTO) {

        DayOff created = dayOffRepo.save(dayOffMapper.toEntity(requestDTO));
        List<User> users = userRepo.findAllByDaysOffDayOffId(created.getDayOffId());
        if (created.getRequestStatus().equals(DayOffStatus.PENDING)) {
            for (var user2 : users) {
                user2.setLeaveDaysLeft(user2.getLeaveDaysLeft() - created.getDayOffAmount());
                userRepo.save(user2);
            }
        }
        return dayOffMapper.toDto(created);
    }
}
