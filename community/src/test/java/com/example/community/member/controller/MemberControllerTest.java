package com.example.community.member.controller;

import com.example.community.company.repository.CompanyLocationRepository;
import com.example.community.company.repository.CompanyTypeRepository;
import com.example.community.member.mapper.MemberMapper;
import com.example.community.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private CompanyLocationRepository companyLocationRepository;

    @MockBean
    private CompanyTypeRepository companyTypeRepository;

    @MockBean
    private MemberMapper mapper;

    @Test
    @DisplayName("모든 회원 조회")
    void getMembersTest1() throws Exception {

    }

    @Test
    @DisplayName("지역과 업종으로 회원 조회")
    void getMembersTest2() throws Exception {

    }

    @Test
    @DisplayName("지역으로 회원 조회")
    void getMembersTest3() throws Exception {

    }

    @Test
    @DisplayName("업종으로 회원 조회")
    void getMembersTest4() throws Exception {

    }
}