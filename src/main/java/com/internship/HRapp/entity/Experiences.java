package com.internship.HRapp.entity;

import com.internship.HRapp.enums.TrustLevel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experiences {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID expId;
    private String company;
    private String positions;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
    private TrustLevel trustLevel;

    @ManyToOne
    @JoinColumn(name="user_exp_id", referencedColumnName = "userId")
    private User users;


    public void setStartTime(int i, int i1, int i2) {
    }

    public void setEndTime(int i, int i1, int i2) {
    }
}
