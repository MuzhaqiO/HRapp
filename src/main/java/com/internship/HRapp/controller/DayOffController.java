package com.internship.HRapp.controller;

import com.internship.HRapp.dto.dayOffDTO.StatusDTO;
import com.internship.HRapp.dto.dayOffDTO.UserDayOffDTO;
import com.internship.HRapp.dto.dayOffDTO.createDayOffDTO;
import com.internship.HRapp.service.concretes.DayOffService;
import com.internship.HRapp.service.interfaces.DayOffServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/hr_management_system/userDayOff")
public class DayOffController {

    private final DayOffServiceInterface dayOffServiceInterface;

    @PostMapping("placeDatOffRequest")
    public ResponseEntity<UserDayOffDTO> placeDayOffRequest(@RequestBody createDayOffDTO requestDTO){
        return ResponseEntity.ok(dayOffServiceInterface.placeDayOffRequest(requestDTO));
    }
    @GetMapping("getDayOffByUser/{userId}")
    public ResponseEntity<List<UserDayOffDTO>> getUserDaysOff(@PathVariable UUID userId) {
        return ResponseEntity.ok(dayOffServiceInterface.getUserDayOff(userId));
    }
//    @PatchMapping(path = "api/updateLeaveDays")
//    public void updateLeaveDaysLeft(){
//        dayOffServiceInterface.updateLeaveDaysLeft();
 //   }

    @PatchMapping("updateDayOff/{dayOffId}")
    public void updateDayOffRequest(@PathVariable UUID dayOffId, @RequestBody StatusDTO status) {
        dayOffServiceInterface.updateDayOffRequest(dayOffId, status);
    }
    @DeleteMapping("deleteDayOff/{dayOffId}")
    public void deleteDayOff(@PathVariable("dayOffId") UUID dayOffId) {
        dayOffServiceInterface.deleteDayOff(dayOffId);
    }

}
