package com.example.community.member.entity;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String name;
    private String password;
    private Member.Gender gender;
    private String companyName;
    private CompanyType companyType;
    private CompanyLocation companyLocation;

}
