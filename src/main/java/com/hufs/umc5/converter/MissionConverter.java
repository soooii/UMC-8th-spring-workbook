package com.hufs.umc5.converter;

import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.MissionRequestDTO;
import com.hufs.umc5.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO toMissionResponseDTO(Mission mission, Long storeId) {
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .storeId(storeId)
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Mission toMission(MissionRequestDTO requestDTO, Store store) {
        return Mission.builder()
                .mission_spec(requestDTO.getMission_spec())
                .store(store)
                .reward(requestDTO.getReward())
                .deadline(requestDTO.getDeadline())
                .build();

    }
}
