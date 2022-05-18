package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.userDTO.UserDTO;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    @Override
    public UserDTO getUserById(UUID userId) {
        return usersMapper.entityToDTO(usersRepo.getById(userId));
    }
    @Override
    public UserDTO getUserByUsername(String username) {
        return usersMapper.entityToDTO(usersRepo.getByUsername(username));
    }
    @Override
    public List<UserDTO> getUsers() {
        return usersMapper.entitiesToDTOs(usersRepo.findAll());
    }
    @Override
    public UserDTO addNewUsers(UserDTO userDTO) {
        User createdUser = usersRepo.save(usersMapper.DTOtoEntity(userDTO));
        return usersMapper.entityToDTO(createdUser);
    }
}
