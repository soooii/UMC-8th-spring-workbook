package com.hufs.umc5.repository.StoreRepository;

import com.hufs.umc5.domain.Store;

import java.util.List;



public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}