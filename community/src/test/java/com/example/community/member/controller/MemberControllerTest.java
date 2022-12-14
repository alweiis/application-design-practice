package com.example.community.member.controller;

import com.example.community.company.entity.CompanyLocation;
import com.example.community.company.entity.CompanyType;
import com.example.community.company.repository.CompanyLocationRepository;
import com.example.community.company.repository.CompanyTypeRepository;
import com.example.community.member.entity.Member;
import com.example.community.member.entity.MemberResponseDto;
import com.example.community.member.mapper.MemberMapper;
import com.example.community.member.service.MemberService;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @DisplayName("?????? ?????? ??????")
    void getMembersTest() throws Exception {
        List<MemberResponseDto> responses = List.of(
                new MemberResponseDto(new Member(
                            1L,
                            "?????????",
                            "1234",
                            Member.Gender.Man,
                            "??????????????????",
                            new CompanyType("001"),
                            new CompanyLocation("031")
                    )
                ),
                new MemberResponseDto(new Member(
                            2L,
                            "?????????",
                            "2345",
                            Member.Gender.Woman,
                            "??????????????????",
                            new CompanyType("001"),
                            new CompanyLocation("031")
                    )
                )
        );

        List<Member> members = List.of(
                new Member(
                        1L,
                        "?????????",
                        "1234",
                        Member.Gender.Man,
                        "??????????????????",
                        new CompanyType("001"),
                        new CompanyLocation("031")
                ),
                new Member(
                        2L,
                        "?????????",
                        "2345",
                        Member.Gender.Woman,
                        "??????????????????",
                        new CompanyType("001"),
                        new CompanyLocation("031")
                )
        );

        given(memberService.findMembers()).willReturn(members);
        given(mapper.membersToMemberResponseDto(Mockito.anyList())).willReturn(responses);

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        actions
            .andExpect(status().isOk())
                .andDo(
                    document(
                        "get-members",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                parameterWithName("type").description("?????? ??????").optional(),
                                parameterWithName("location").description("?????? ??????").optional()
                        ),
                        responseFields(
                                Arrays.asList(
                                    fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("?????? ??????"),
                                    fieldWithPath("[].name").type(JsonFieldType.STRING).description("??????"),
                                    fieldWithPath("[].password").type(JsonFieldType.STRING).description("????????????"),
                                    fieldWithPath("[].gender").type(JsonFieldType.STRING).description("??????: Man / Woman"),
                                    fieldWithPath("[].companyName").type(JsonFieldType.STRING).description("?????? ??????"),
                                    fieldWithPath("[].companyType").type(JsonFieldType.NUMBER).description("?????? ??????"),
                                    fieldWithPath("[].companyLocation").type(JsonFieldType.NUMBER).description("?????? ??????")
                                )
                        )
                    )
            )
                .andReturn();
    }
}