package com.example.community.member.controller;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import com.example.community.company.repository.CompanyLocationRepository;
import com.example.community.company.repository.CompanyTypeRepository;
import com.example.community.member.entity.Member;
import com.example.community.member.entity.MemberResponseDto;
import com.example.community.member.mapper.MemberMapper;
import com.example.community.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final CompanyLocationRepository companyLocationRepository;
    private final CompanyTypeRepository companyTypeRepository;

    private final MemberMapper mapper;

    @GetMapping
    public ResponseEntity getMembers(@RequestParam(required = false) String location,
                                     @RequestParam(required = false) String type) {
        List<Member> members;

        if (type != null && location != null) {
            CompanyLocation companyLocation = companyLocationRepository.findCompanyLocationByLocationName(location);
            CompanyType companyType = companyTypeRepository.findCompanyTypeByTypeName(type);
            members = memberService.findMemberByCompanyLocationAndAndCompanyType(companyLocation, companyType);
        } else if (type != null) {
            CompanyType companyType = companyTypeRepository.findCompanyTypeByTypeName(type);
            members = memberService.findMemberByCompanyType(companyType);
        } else if (location != null) {
            CompanyLocation companyLocation = companyLocationRepository.findCompanyLocationByLocationName(location);
            members = memberService.findMemberByCompanyLocation(companyLocation);
        } else {
            members = memberService.findMembers();
        }

        List<MemberResponseDto> response =
                members.stream()
                        .map(member -> mapper.memberToMemberResponseDto(member))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
