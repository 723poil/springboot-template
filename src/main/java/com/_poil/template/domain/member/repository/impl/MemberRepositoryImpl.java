package com._poil.template.domain.member.repository.impl;

import static com._poil.template.entity.QMember.member;

import com._poil.template.domain.member.dto.MemberDto;
import com._poil.template.domain.member.repository.QMemberRepository;
import com._poil.template.entity.QMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberRepositoryImpl extends QuerydslRepositorySupport
    implements QMemberRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(QMember.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<MemberDto> findMemberList() {
        return jpaQueryFactory.from(member).select(Projections.constructor(MemberDto.class,
                member))
            .fetch();
    }
}
