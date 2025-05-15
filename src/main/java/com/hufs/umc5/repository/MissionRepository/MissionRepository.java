package com.hufs.umc5.repository.MissionRepository;

import com.hufs.umc5.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {
}
