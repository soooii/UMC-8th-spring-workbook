package com.hufs.umc5.repository.MemberMissionRepository;

import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {

    // 미션 상태에 따른 멤버의 미션 조회
    List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status, String region);
}
