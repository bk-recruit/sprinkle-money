package me.bk.sprinklemoney.service;

import lombok.RequiredArgsConstructor;
import me.bk.sprinklemoney.dto.SprinkleMoneyRequestDto;
import me.bk.sprinklemoney.entity.ChatRoom;
import me.bk.sprinklemoney.entity.SprinklePool;
import me.bk.sprinklemoney.repository.ChatRoomRepository;
import me.bk.sprinklemoney.repository.SprinklePoolRepository;
import me.bk.sprinklemoney.utils.TokenGenerator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SprinkleService {

    private final SprinklePoolRepository sprinklePoolRepository;
    private final ChatRoomRepository chatRoomRepository;

    public SprinklePool sprinkleMoney(int xUserId, String xRoomId, SprinkleMoneyRequestDto sprinkleMoneyRequestDto) {
        ChatRoom findChatRoom = chatRoomRepository.findByxRoomId(xRoomId);
        SprinklePool sprinklePool = new SprinklePool(findChatRoom, sprinkleMoneyRequestDto, TokenGenerator.generateSprinkleRequestToken());
        sprinklePool.addSprinkleTarget();
        sprinklePoolRepository.save(sprinklePool);
        return sprinklePool;
    }
}
