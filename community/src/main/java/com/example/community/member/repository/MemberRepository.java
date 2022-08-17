package com.example.community.member.repository;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import com.example.community.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findMembersByCompanyLocation(CompanyLocation companyLocation);
    List<Member> findMembersByCompanyType(CompanyType companyType);
    List<Member> findMembersByCompanyLocationAndAndCompanyType(
            CompanyLocation companyLocation,
            CompanyType companyType
    );
}
