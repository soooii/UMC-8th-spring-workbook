package com.hufs.umc5.repository.MissionRepository;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Mission;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
