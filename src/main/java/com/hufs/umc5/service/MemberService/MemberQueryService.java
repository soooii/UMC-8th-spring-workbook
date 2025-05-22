package com.hufs.umc5.service.MemberService;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;


public interface MemberQueryService {
    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);
}

