package com.hufs.umc5.service.MemberMissionService;

import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {

    List<MemberMission> findMemberMissionsByMemberIdAndMissionStatus(Long id, MissionStatus status, String region);

}
