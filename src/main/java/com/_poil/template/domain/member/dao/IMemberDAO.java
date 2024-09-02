package com._poil.template.domain.member.dao;

import com._poil.template.domain.member.dto.MemberDto;
import java.util.List;

public interface IMemberDAO {

    public List<MemberDto> find();
}
