package com.internship.HRapp.controller;

import com.internship.HRapp.dto.StatusDTO;
import com.internship.HRapp.dto.UserDayOffDTO;
import com.internship.HRapp.dto.createDayOffDTO;
import com.internship.HRapp.service.interfaces.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/userDayOff")
public class DayOffController {

    private final DayOffService dayOffService;

    @PostMapping("api/test")
    public ResponseEntity<UserDayOffDTO> placeDayOffRequest(@RequestBody createDayOffDTO requestDTO){
        return ResponseEntity.ok(dayOffService.placeDayOffRequest(requestDTO));
    }
    @GetMapping("{id}")
    public ResponseEntity<List<UserDayOffDTO>> getUserDaysOff(@PathVariable UUID id) {
        return ResponseEntity.ok(dayOffService.getUserDayOff(id));
    }
//    @PatchMapping(path = "api/updateLeaveDays")
//    public void updateLeaveDaysLeft(){
//        dayOffService.updateLeaveDaysLeft();
 //   }

    @PatchMapping
    public void updateDayOffRequest(
            @RequestParam StatusDTO status) {
        dayOffService.updateDayOffRequest(status);
    }


    @DeleteMapping(path = "{dayOffId}")
    public void deleteDayOff(@PathVariable("dayOffId") UUID dayOffId) {
        dayOffService.deleteDayOff(dayOffId);
    }

}
