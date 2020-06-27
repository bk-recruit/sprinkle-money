package me.bk.sprinklemoney.repository;

import me.bk.sprinklemoney.entity.ChatMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMemberRepository extends JpaRepository<ChatMember, Long> {
}
