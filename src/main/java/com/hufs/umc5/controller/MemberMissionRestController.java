package com.hufs.umc5.controller;

import com.hufs.umc5.apiPayload.ApiResponse;
import com.hufs.umc5.converter.MemberMissionConverter;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionRequestDTO;
import com.hufs.umc5.dto.MemberMissionResponseDTO;
import com.hufs.umc5.service.MemberMissionService.MemberMissionCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberMissions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    // 4. 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API

    @PostMapping("/challenging")
    public ApiResponse<MemberMissionResponseDTO> toChallenging(@Valid @RequestBody MemberMissionRequestDTO requestDTO) {
        MemberMission memberMission = memberMissionCommandService.toChallenging(requestDTO);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDTO(memberMission));

    }
}
