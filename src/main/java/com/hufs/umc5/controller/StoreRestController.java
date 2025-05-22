package com.hufs.umc5.controller;

import com.hufs.umc5.apiPayload.ApiResponse;
import com.hufs.umc5.converter.MissionConverter;
import com.hufs.umc5.converter.ReviewConverter;
import com.hufs.umc5.converter.StoreConverter;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.*;
import com.hufs.umc5.service.StoreService.StoreCommandService;
import com.hufs.umc5.service.StoreService.StoreQueryService;
import com.hufs.umc5.validation.annotation.ExistStore;
import com.hufs.umc5.validation.annotation.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;


    // 1. 특정 지역에 가게 추가하기 API
    @PostMapping("/{regionId}")
    public ApiResponse<StoreResponseDTO> addStore(@PathVariable Long regionId, @RequestBody StoreRequestDTO request){
        Store store = storeCommandService.addStore(request, regionId);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }

    // 2. 가게에 리뷰 추가하기 API
    @PostMapping("/{storeId}/review")
    public ApiResponse<ReviewResponseDTO> addReview(@ExistStore @PathVariable(name="storeId") Long storeId, @RequestBody ReviewRequestDTO request){
        Review review = storeCommandService.addReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDTO(review, storeId));
    }

    // 3. 가게에 미션 추가하기 API
    @PostMapping("/{storeId}/mission")
    public ApiResponse<MissionResponseDTO> addMission(@PathVariable Long storeId, @RequestBody MissionRequestDTO request){
        Mission mission = storeCommandService.addMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission, storeId));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") @ValidPage Integer page){
        int minus = page-1;
        Page<Review> reviewList = storeQueryService.getReviewList(storeId,minus);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") @ValidPage Integer page){
        int minus = page-1;
        Page<Mission> missionList = storeQueryService.getMissionList(storeId,minus);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }


}
