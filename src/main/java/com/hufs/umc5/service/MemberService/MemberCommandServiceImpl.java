package com.hufs.umc5.service.MemberService;

import com.hufs.umc5.apiPayload.code.status.ErrorStatus;

import com.hufs.umc5.converter.MemberConverter;
import com.hufs.umc5.converter.MemberPreferConverter;
import com.hufs.umc5.domain.FoodCategory;
import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.mapping.MemberPrefer;
import com.hufs.umc5.dto.MemberRequestDTO;

import com.hufs.umc5.exception.handler.FoodCategoryHandler;

import com.hufs.umc5.repository.FoodCategoryRepository.FoodCategoryRepository;
import com.hufs.umc5.repository.MemberRepository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        // request -> entity
        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());


        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

}

