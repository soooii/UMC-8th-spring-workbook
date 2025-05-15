package com.hufs.umc5.dto;

import com.hufs.umc5.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionResponseDTO {
    private Long MemberMissionId;
    private MissionStatus status;
}
