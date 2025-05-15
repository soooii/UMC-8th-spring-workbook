package com.hufs.umc5.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO{
    private String body;
    private Long score;
    private LocalDateTime createdAt;
}