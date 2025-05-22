package com.hufs.umc5.controller;

import com.hufs.umc5.apiPayload.ApiResponse;
import com.hufs.umc5.converter.MemberMissionConverter;
import com.hufs.umc5.converter.MissionConverter;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionRequestDTO;
import com.hufs.umc5.dto.MemberMissionResponseDTO;
import com.hufs.umc5.dto.MissionResponseDTO;
import com.hufs.umc5.service.MemberMissionService.MemberMissionCommandService;
import com.hufs.umc5.service.MemberMissionService.MemberMissionQueryService;
import com.hufs.umc5.validation.annotation.IfChallenging;
import com.hufs.umc5.validation.annotation.IfComplete;
import com.hufs.umc5.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Validated
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    // 4. 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API

    @PostMapping("/missions/challenging")
    @Operation(summary = "특정 멤버의 미션을 진행 상태로 바꿔주는 API",description = "특정 멤버의 미션을 진행 상태로 바꿔주는 API입니다.")
    public ApiResponse<MemberMissionResponseDTO> toChallenging(@Valid @IfChallenging @RequestBody MemberMissionRequestDTO requestDTO) {
        MemberMission memberMission = memberMissionCommandService.toChallenging(requestDTO);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDTO(memberMission));

    }

    @GetMapping("/{memberId}/missions/challenging")
    @Operation(summary = "특정 멤버의 진행중 미션 목록 조회 API",description = "특정 멤버의 진행중인 미션의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getChallengingMissionList(@PathVariable Long memberId, @RequestParam(name = "page") @ValidPage Integer page){
        int minus = page-1;
        Page<Mission> missionList = memberMissionQueryService.getMemberMissionList(memberId, MissionStatus.CHALLENGING, minus);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

    @PostMapping("/missions/complete")
    @Operation(summary = "특정 멤버의 진행중 미션을 완료 상태로 바꿔주는 API",description = "특정 멤버의 진행 중인 미션을 완료 상태로 바꿔주는 API입니다.")
    public ApiResponse<MemberMissionResponseDTO> toCompleteMission(@Valid @IfComplete @RequestBody MemberMissionRequestDTO requestDTO){
        MemberMission memberMission = memberMissionCommandService.toComplete(requestDTO);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDTO(memberMission));
    }

}
