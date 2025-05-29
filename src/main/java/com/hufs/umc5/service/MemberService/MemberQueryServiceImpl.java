package com.hufs.umc5.service.MemberService;

import com.hufs.umc5.apiPayload.code.status.ErrorStatus;

import com.hufs.umc5.converter.MemberConverter;
import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.Review;
import com.hufs.umc5.domain.Store;
import com.hufs.umc5.dto.MemberResponseDTO;
import com.hufs.umc5.exception.handler.MemberHandler;
import com.hufs.umc5.repository.MemberRepository.MemberRepository;
import com.hufs.umc5.repository.ReviewRepository.ReviewRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;


    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberPage;
    }


}
