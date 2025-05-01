package com.hufs.umc5.service.MemberMissionService;

import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.repository.MemberMissionRepository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMission> findMemberMissionsByMemberIdAndMissionStatus(Long id, MissionStatus status, String region) {

        List<MemberMission> filteredMemberMissions = memberMissionRepository.dynamicQueryWithBooleanBuilder(id, status, region);
        filteredMemberMissions.forEach(mission -> System.out.println("MemberMission: " + mission));
        return filteredMemberMissions;
    }
}
