package com.hufs.umc5.dto;

import com.hufs.umc5.validation.annotation.IfChallenging;
import lombok.Getter;

@IfChallenging
@Getter
public class MemberMissionRequestDTO {
    private Long missionId;
    private Long memberId;
}
