package com.hufs.umc5.repository.MemberMissionRepository;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    Page<MemberMission> findMemberMissionByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);
}
