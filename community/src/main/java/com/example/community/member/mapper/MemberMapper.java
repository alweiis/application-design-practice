package com.example.community.member.mapper;

import com.example.community.member.entity.Member;
import com.example.community.member.entity.MemberResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    List<MemberResponseDto> membersToMemberResponseDto(List<Member> members);
}
