package com.hufs.umc5.service.MemberMissionService;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.repository.MemberMissionRepository.MemberMissionRepository;
import com.hufs.umc5.repository.MemberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<MemberMission> findMemberMissionsByMemberIdAndMissionStatus(Long id, MissionStatus status, String region) {

        List<MemberMission> filteredMemberMissions = memberMissionRepository.dynamicQueryWithBooleanBuilder(id, status, region);
        filteredMemberMissions.forEach(mission -> System.out.println("MemberMission: " + mission));
        return filteredMemberMissions;
    }

    @Override
    public Page<Mission> getMemberMissionList(Long memberId, MissionStatus status, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> memberMissionPage= memberMissionRepository.findMemberMissionByMemberAndStatus(member, status, PageRequest.of(page, 10));
        return memberMissionPage.map(MemberMission::getMission);
    }
}
