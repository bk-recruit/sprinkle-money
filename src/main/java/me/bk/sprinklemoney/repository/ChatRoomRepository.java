package me.bk.sprinklemoney.repository;

import me.bk.sprinklemoney.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByxRoomId(String xRoomId);
}
