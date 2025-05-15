package com.hufs.umc5.controller;

import com.hufs.umc5.apiPayload.ApiResponse;
import com.hufs.umc5.converter.MemberConverter;
import com.hufs.umc5.domain.Member;
import com.hufs.umc5.dto.MemberRequestDTO;
import com.hufs.umc5.dto.MemberResponseDTO;
import com.hufs.umc5.service.MemberService.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
