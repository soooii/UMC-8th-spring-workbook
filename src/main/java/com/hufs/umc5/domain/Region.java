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

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();

}

