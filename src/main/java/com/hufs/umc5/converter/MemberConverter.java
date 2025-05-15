package com.hufs.umc5.converter;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.domain.enums.Gender;
import com.hufs.umc5.dto.MemberRequestDTO;
import com.hufs.umc5.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    // 회원가입 후 만든 엔티티 저장, 해당 멤버 엔티티 -> ResponseDTO
    // Member 엔티티 → JoinResultDTO로 변환
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 회원가입 requestDTO -> 회원 엔티티로 변환
    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            //case 3:
                //gender = Gender.NONE;
                //break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
