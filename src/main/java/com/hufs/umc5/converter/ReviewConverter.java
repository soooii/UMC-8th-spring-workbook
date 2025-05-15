package com.hufs.umc5.converter;

import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.ReviewRequestDTO;
import com.hufs.umc5.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO toReviewResponseDTO(Review review, Long storeId) {
        return ReviewResponseDTO.builder()
                // 저장되면 아이디 자동 생성, response에서 확인
                .reviewId(review.getId())
                .storeId(storeId)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO requestDTO, Store store) {
        return Review.builder()
                .score(requestDTO.getScore())
                .body(requestDTO.getBody())
                .store(store)
                .build();

    }
}
