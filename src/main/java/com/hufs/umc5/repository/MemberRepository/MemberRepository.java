package com.hufs.umc5.repository.MemberRepository;

import com.hufs.umc5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByEmail(String email);
}
