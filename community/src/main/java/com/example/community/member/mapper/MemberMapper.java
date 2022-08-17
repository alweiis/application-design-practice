package com.example.community.member.mapper;

import com.example.community.member.entity.Member;
import com.example.community.member.entity.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberResponseDto memberToMemberResponseDto(Member member);
}
