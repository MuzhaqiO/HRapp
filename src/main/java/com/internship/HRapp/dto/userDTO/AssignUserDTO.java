package com.internship.HRapp.dto.userDTO;

import lombok.Data;

import java.util.List;

@Data
public class AssignUserDTO {
    private List<GetUsersDTO> users;
}
