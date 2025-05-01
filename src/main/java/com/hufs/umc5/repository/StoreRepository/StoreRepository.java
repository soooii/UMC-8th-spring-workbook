package com.hufs.umc5.repository.StoreRepository;

import com.hufs.umc5.domain.Store;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
