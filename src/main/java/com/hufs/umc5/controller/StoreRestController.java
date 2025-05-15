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
import com.hufs.umc5.validation.annotation.ExistStore;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

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


}
