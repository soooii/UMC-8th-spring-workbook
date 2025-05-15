package com.hufs.umc5.repository.MemberMissionRepository;

import com.hufs.umc5.domain.enums.MissionStatus;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.domain.mapping.QMemberMission;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission mission = QMemberMission.memberMission;


    @Override
    public List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status, String region) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(mission.member.id.eq(memberId));
        }

        if(status != null) {
            predicate.and(mission.status.eq(status));
        }

        if(region != null) {
           predicate.and(mission.mission.store.region.name.eq(region));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }

    @Override
    public MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId) {
        return jpaQueryFactory
                .selectFrom(mission)
                .where(mission.member.id.eq(memberId)
                        .and(mission.mission.id.eq(missionId))
                )
                .fetchOne();
    }
}
