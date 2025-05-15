package com.hufs.umc5.converter;


import com.hufs.umc5.domain.mapping.MemberMission;
import com.hufs.umc5.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO toMemberMissionResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.builder()
                .MemberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .build();
    }

}
