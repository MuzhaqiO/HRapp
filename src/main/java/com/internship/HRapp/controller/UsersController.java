package com.internship.HRapp.controller;

import com.internship.HRapp.dto.UsersDTO;
import com.internship.HRapp.entity.Users;
import com.internship.HRapp.mapper.UsersMapper;
import com.internship.HRapp.service.concretes.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hr_management_system/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersServiceImpl usersServiceImpl;
    private final UsersMapper usersMapper;
    @PostMapping("addUser")
    public ResponseEntity<Users> saveUsers(@RequestBody UsersDTO usersDTO){
        return new ResponseEntity<>(usersServiceImpl.addNewUsers(
                usersMapper.DTOtoEntity(usersDTO)),HttpStatus.CREATED);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<UsersDTO>> findAllUsers() {
        return new ResponseEntity<>(usersMapper.entitysToDTOs(usersServiceImpl.getUsers()), HttpStatus.OK);
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UsersDTO> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(usersMapper.entityToDTO(usersServiceImpl.getUserByUsername(username)),HttpStatus.OK);
    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable UUID userId){
        return new ResponseEntity<>(usersMapper.entityToDTO(usersServiceImpl.getUserById(userId)),HttpStatus.OK);

    }
    @DeleteMapping("del_id/{userId}")
    public ResponseEntity<String> deleteUsersById(@PathVariable UUID userId){
        UsersDTO usersDTO = usersMapper.entityToDTO(usersServiceImpl.getUserById(userId));
        usersServiceImpl.deleteUsersById(usersDTO.getUserId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{userId}")
    public Users updateUsers(Users users) {
        return usersServiceImpl.updateUsers(users);
    }
}