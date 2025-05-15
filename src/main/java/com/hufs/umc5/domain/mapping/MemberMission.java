package com.hufs.umc5.domain.mapping;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.common.BaseEntity;
import com.hufs.umc5.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void updateStatus(MissionStatus newStatus) {
        this.status = newStatus;
    }
}
