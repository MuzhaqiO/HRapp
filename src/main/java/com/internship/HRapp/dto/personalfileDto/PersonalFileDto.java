package com.internship.HRapp.dto.personalfileDto;

import lombok.Data;
import lombok.Getter;

import java.net.URL;
import java.util.UUID;

@Data
@Getter

public class PersonalFileDto{
    private UUID personalFileId;
    private URL id_card;
    private URL degree;
    private String working_skills;
}