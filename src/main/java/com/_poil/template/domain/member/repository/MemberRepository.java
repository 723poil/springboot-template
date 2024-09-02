package com._poil.template.domain.member.repository;

import com._poil.template.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer>, QMemberRepository {

}
