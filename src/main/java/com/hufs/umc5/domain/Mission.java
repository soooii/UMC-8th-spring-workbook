package com.hufs.umc5.domain;

import com.hufs.umc5.domain.common.BaseEntity;
import com.hufs.umc5.domain.enums.Gender;
import com.hufs.umc5.domain.enums.MemberStatus;
import com.hufs.umc5.domain.enums.SocialType;
import com.hufs.umc5.domain.mapping.MemberAgree;
import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long reward;

    private LocalDateTime deadline;

    private String mission_spec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}