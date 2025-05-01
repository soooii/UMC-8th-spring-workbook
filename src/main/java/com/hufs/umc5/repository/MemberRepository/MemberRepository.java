package com.hufs.umc5.repository.MemberRepository;

import com.hufs.umc5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
