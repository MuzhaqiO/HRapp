package com.internship.HRapp.entity;

import com.internship.HRapp.enumeration.TrustLevel;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    private UUID userId;
    private String company;
    private String positions;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
    private TrustLevel trustLevel;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="user_exp_id")
    private Users users;


    public void setStartTime(int i, int i1, int i2) {
    }

    public void setEndTime(int i, int i1, int i2) {
    }
}
