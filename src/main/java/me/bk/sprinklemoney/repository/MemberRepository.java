package me.bk.sprinklemoney.repository;

import me.bk.sprinklemoney.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
