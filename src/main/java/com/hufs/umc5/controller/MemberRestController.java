package com.hufs.umc5.controller;

import com.hufs.umc5.apiPayload.ApiResponse;
import com.hufs.umc5.apiPayload.code.ErrorReasonDTO;
import com.hufs.umc5.apiPayload.code.status.ErrorStatus;
import com.hufs.umc5.converter.MemberConverter;
import com.hufs.umc5.converter.MissionConverter;
import com.hufs.umc5.converter.ReviewConverter;
import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.dto.MemberRequestDTO;
import com.hufs.umc5.dto.MemberResponseDTO;
import com.hufs.umc5.dto.MissionResponseDTO;
import com.hufs.umc5.dto.ReviewResponseDTO;
import com.hufs.umc5.exception.GeneralException;
import com.hufs.umc5.service.MemberService.MemberCommandService;
import com.hufs.umc5.service.MemberService.MemberQueryService;
import com.hufs.umc5.validation.annotation.ValidPage;
import com.hufs.umc5.web.annotation.MinusOnePage;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
@Validated
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API",description = "특정 멤버의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable Long memberId, @RequestParam(name = "page") @MinusOnePage @ValidPage Integer page){
        int minus = page-1;
        Page<Review> reviewList = memberQueryService.getReviewList(memberId,minus);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }



}
