package com.hufs.umc5.repository.ReviewRepository;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
