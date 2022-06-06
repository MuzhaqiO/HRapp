package com.internship.HRapp.controller;

import com.internship.HRapp.dto.dayOffDTO.StatusDTO;
import com.internship.HRapp.dto.dayOffDTO.UserDayOffDTO;
import com.internship.HRapp.dto.dayOffDTO.createDayOffDTO;
import com.internship.HRapp.service.concretes.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/hr_management_system/userDayOff")
public class DayOffController {

    private final DayOffService dayOffService;

    @PostMapping("placeDatOffRequest")
    public ResponseEntity<UserDayOffDTO> placeDayOffRequest(@RequestBody createDayOffDTO requestDTO){
        return ResponseEntity.ok(dayOffService.placeDayOffRequest(requestDTO));
    }
    @GetMapping("getDayOffByUser/{userId}")
    public ResponseEntity<List<UserDayOffDTO>> getUserDaysOff(@PathVariable UUID userId) {
        return ResponseEntity.ok(dayOffService.getUserDayOff(userId));
    }
//    @PatchMapping(path = "api/updateLeaveDays")
//    public void updateLeaveDaysLeft(){
//        dayOffService.updateLeaveDaysLeft();
 //   }

    @PatchMapping("updateDayOff/{dayOffId}")
    public void updateDayOffRequest(@PathVariable UUID dayOffId, @RequestBody StatusDTO status) {
        dayOffService.updateDayOffRequest(dayOffId, status);
    }
    @DeleteMapping("deleteDayOff/{dayOffId}")
    public void deleteDayOff(@PathVariable("dayOffId") UUID dayOffId) {
        dayOffService.deleteDayOff(dayOffId);
    }

}
