package com.example.community.member.entity;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CompanyType companyType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private CompanyLocation companyLocation;

    public enum Gender {
        Man, Woman
    }
}
