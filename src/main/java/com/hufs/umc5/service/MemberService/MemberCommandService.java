package com.hufs.umc5.service.MemberService;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.dto.MemberRequestDTO;


public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto requestDTO);
}
