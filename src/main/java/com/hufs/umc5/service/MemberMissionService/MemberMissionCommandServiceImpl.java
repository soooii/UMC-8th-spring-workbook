package com.hufs.umc5.service.MemberMissionService;

import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionRequestDTO;
import com.hufs.umc5.repository.MemberMissionRepository.MemberMissionRepository;
import com.hufs.umc5.repository.MissionRepository.MissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission toChallenging(MemberMissionRequestDTO request) {

        MemberMission memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(request.getMissionId(), request.getMemberId());
        memberMission.updateStatus(MissionStatus.CHALLENGING);

        return memberMission;
    }

    @Override
    @Transactional
    public MemberMission toComplete(MemberMissionRequestDTO request) {
        MemberMission memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(request.getMissionId(), request.getMemberId());
        log.info(memberMission.toString());
        memberMission.updateStatus(MissionStatus.COMPLETE);
        log.info(memberMission.toString());
        return memberMission;
    }
}
