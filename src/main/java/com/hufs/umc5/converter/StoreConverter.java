package com.hufs.umc5.converter;

import com.hufs.umc5.domain.Region;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.StoreRequestDTO;
import com.hufs.umc5.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO toStoreResponseDTO(Store store) {
        // 가게가 지역에 추가됐는지 보려면 가게 엔티티에서 region을 가져와야할 것 같다는 생각
        return StoreResponseDTO.builder()
                .regionId(store.getRegion().getId())
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Store toStore(StoreRequestDTO requestDTO, Region region) {
        return Store.builder()
                .region(region)
                .score(requestDTO.getScore())
                .address(requestDTO.getAddress())
                .name(requestDTO.getName())
                .build();
    }
}
