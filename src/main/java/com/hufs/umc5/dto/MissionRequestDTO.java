package com.hufs.umc5.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MissionRequestDTO {
    private Long id;

    private Long reward;

    private LocalDateTime deadline;

    private String mission_spec;

    // Todo-memberId 넣기 유무?
}
