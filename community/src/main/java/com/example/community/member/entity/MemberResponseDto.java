package com.example.community.member.entity;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String name;
    private String password;
    private Member.Gender gender;
    private String companyName;
    private Long companyType;
    private Long companyLocation;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.gender = member.getGender();
        this.companyName = member.getCompanyName();
        this.companyType = Long.parseLong(member.getCompanyType().getTypeName());
        this.companyLocation = Long.parseLong(member.getCompanyLocation().getLocationName());
    }
}
