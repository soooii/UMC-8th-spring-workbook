package com.hufs.umc5.service.MemberMissionService;

import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {

    MemberMission toChallenging(MemberMissionRequestDTO request);
}
