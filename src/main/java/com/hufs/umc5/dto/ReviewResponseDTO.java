package com.hufs.umc5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO{
    private Long reviewId;
    private Long storeId;
    private LocalDateTime createdAt;
}
