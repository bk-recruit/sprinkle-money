package me.bk.sprinklemoney.service;

import me.bk.sprinklemoney.dto.SprinkleMoneyRequestDto;
import me.bk.sprinklemoney.dto.SprinkleMoneyResponseDto;
import me.bk.sprinklemoney.entity.ChatMember;
import me.bk.sprinklemoney.entity.ChatRoom;
import me.bk.sprinklemoney.entity.SprinklePool;
import me.bk.sprinklemoney.repository.ChatMemberRepository;
import me.bk.sprinklemoney.repository.ChatRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class SprinkleServiceTest {

    @Autowired
    ChatMemberRepository chatMemberRepository;
    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    SprinkleService sprinkleService;

    @Test
    void 뿌리기() throws Exception {
        //given
        Optional<ChatMember> chatMemberOptional = chatMemberRepository.findById(Long.valueOf(5));
        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(Long.valueOf(4));

        ChatMember chatMember = chatMemberOptional.get();
        ChatRoom chatRoom = chatRoomOptional.get();

        SprinkleMoneyRequestDto sprinkleMoneyRequestDto = new SprinkleMoneyRequestDto(10000, 5);

        //when
        SprinklePool sprinklePool = sprinkleService.sprinkleMoney(chatMember.getMember().getXUserId(),
                chatMember.getChatRoom().getXRoomId(),
                sprinkleMoneyRequestDto);
        SprinkleMoneyResponseDto sprinkleMoneyResponseDto = new SprinkleMoneyResponseDto(sprinklePool);
        //then
        assertNotNull(sprinkleMoneyResponseDto.getToken());
    }

}