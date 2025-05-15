package com.hufs.umc5.service.StoreService;

import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.MissionRequestDTO;
import com.hufs.umc5.dto.ReviewRequestDTO;
import com.hufs.umc5.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review addReview(ReviewRequestDTO request, Long storeId);
    Mission addMission(MissionRequestDTO request, Long storeId);
    Store addStore(StoreRequestDTO request, Long regionId);
}
