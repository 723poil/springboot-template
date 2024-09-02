package com._poil.template.domain.member.repository;

import com._poil.template.domain.member.dto.MemberDto;
import java.util.List;

public interface QMemberRepository {

    public List<MemberDto> findMemberList();
}
