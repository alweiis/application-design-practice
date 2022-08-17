package com.example.community.member.service;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import com.example.community.member.entity.Member;
import com.example.community.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public List<Member> findMemberByCompanyLocation(CompanyLocation companyLocation) {
        return memberRepository.findMembersByCompanyLocation(companyLocation);
    }

    public List<Member> findMemberByCompanyType(CompanyType companyType) {
        return memberRepository.findMembersByCompanyType(companyType);
    }

    public List<Member> findMemberByCompanyLocationAndAndCompanyType(
            CompanyLocation companyLocation,
            CompanyType companyType)
    {
        return memberRepository.findMembersByCompanyLocationAndAndCompanyType(
                companyLocation,
                companyType
        );
    }
}
