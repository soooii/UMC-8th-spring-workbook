package com.hufs.umc5.service.MemberMissionService;

import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberMissionQueryService {


    List<MemberMission> findMemberMissionsByMemberIdAndMissionStatus(Long id, MissionStatus status, String region);

    // 미션 상태에 따라 해당 멤버 미션 목록 가져오기
    Page<Mission> getMemberMissionList(Long memberId, MissionStatus status, Integer page);

}
