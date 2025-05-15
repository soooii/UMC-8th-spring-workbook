package com.hufs.umc5.domain;

import com.hufs.umc5.domain.common.BaseEntity;
import com.hufs.umc5.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    foodCategory에서 어떤 멤버가 좋아하는지 알 필요는 없다 -> 단방향 충분
//    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
//    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}