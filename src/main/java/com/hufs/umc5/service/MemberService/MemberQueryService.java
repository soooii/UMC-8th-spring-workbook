package com.hufs.umc5.service.MemberService;

import com.hufs.umc5.domain.Member;
import java.util.Optional;


public interface MemberQueryService {
    Optional<Member> findMember(Long id);
}

