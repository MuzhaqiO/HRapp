package com.internship.HRapp.entity;

import com.internship.HRapp.enumeration.TrustLevel;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experiences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID expId;
    private Long userId;

 /*   public Set<Users> getUsersExperience() {
        return usersExperience;
    }*/

  //  public Set<Users> usersExperience = new HashSet<>();
    private String company;
    private String positions;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
    private TrustLevel trustLevel;


}
