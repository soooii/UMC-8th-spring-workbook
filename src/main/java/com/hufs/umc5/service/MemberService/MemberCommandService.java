package com.hufs.umc5.service.MemberService;

import com.hufs.umc5.domain.Member;
import com.hufs.umc5.dto.MemberRequestDTO;
import com.hufs.umc5.dto.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto requestDTO);

    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);

}
