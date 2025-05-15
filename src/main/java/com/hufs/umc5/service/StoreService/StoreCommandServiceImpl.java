package com.hufs.umc5.service.StoreService;

import com.hufs.umc5.apiPayload.code.status.ErrorStatus;
import com.hufs.umc5.converter.MissionConverter;
import com.hufs.umc5.converter.ReviewConverter;
import com.hufs.umc5.converter.StoreConverter;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.Region;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.MissionRequestDTO;
import com.hufs.umc5.dto.ReviewRequestDTO;
import com.hufs.umc5.dto.StoreRequestDTO;
import com.hufs.umc5.exception.handler.RegionHandler;
import com.hufs.umc5.exception.handler.StoreHandler;
import com.hufs.umc5.repository.MissionRepository.MissionRepository;
import com.hufs.umc5.repository.RegionRepository.RegionRepository;
import com.hufs.umc5.repository.ReviewRepository.ReviewRepository;
import com.hufs.umc5.repository.StoreRepository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO request, Long storeId) {

        // Todo - 멤버 추가?
        //validation을 커스텀 annotation으로 진행하면 서비스단 처리 불필요가 but DB 상태 변화 가능에 따른 이중 보안?
        Store store= storeRepository.findById(storeId).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, store);

        // JpaRepository의 save() 메서드는 저장된 엔티티를 반환
        return reviewRepository.save(review);
    }

    @Override
    public Mission addMission(MissionRequestDTO request, Long storeId) {
        Store store= storeRepository.findById(storeId).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(request, store);

        return missionRepository.save(mission);
    }

    @Override
    public Store addStore(StoreRequestDTO request, Long regionId) {
        Region region = regionRepository.findById(regionId).orElseThrow(()->new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = StoreConverter.toStore(request, region);
        return storeRepository.save(store);
    }
}
