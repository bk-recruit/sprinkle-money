package me.bk.sprinklemoney.config;

import lombok.RequiredArgsConstructor;
import me.bk.sprinklemoney.entity.ChatRoom;
import me.bk.sprinklemoney.entity.Member;
import me.bk.sprinklemoney.repository.ChatMemberRepository;
import me.bk.sprinklemoney.repository.ChatRoomRepository;
import me.bk.sprinklemoney.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Transactional
public class InitSampleDB {

    private final InitSampleService initSampleService;

    @PostConstruct
    public void init() {
        initSampleService.initChatMembers();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitSampleService {

        private final MemberRepository memberRepository;

        private final ChatRoomRepository chatRoomRepository;

        private final ChatMemberRepository chatMemberRepository;

        public void initChatMembers() {

            Member member1 = new Member(100, "ryon@kakaopaycorp.com", "라이언");
            Member member2 = new Member(101, "muzi@kakaopaycorp.com", "무지");
            Member member3 = new Member(102, "apeach@kakaopaycorp.com", "어피치");
            Member member4 = new Member(103, "jay-g@kakaopaycorp.com", "제이지");
            Member member5 = new Member(104, "frodo@kakaopaycorp.com", "프로도");
            Member member6 = new Member(105, "neo@kakaopaycorp.com", "네오");
            Member member7 = new Member(106, "tube@kakaopaycorp.com", "튜브");
            Member member8 = new Member(107, "con@kakaopaycorp.com", "콘");

            memberRepository.save(member1);
            memberRepository.save(member2);
            memberRepository.save(member3);
            memberRepository.save(member4);
            memberRepository.save(member5);
            memberRepository.save(member6);
            memberRepository.save(member7);
            memberRepository.save(member8);

            ChatRoom chatRoom1 = new ChatRoom().create(Arrays.asList(member1, member2, member3));
            ChatRoom chatRoom2 = new ChatRoom().create(Arrays.asList(member3, member4, member5));
            ChatRoom chatRoom3 = new ChatRoom().create(Arrays.asList(member5, member6, member7));
            ChatRoom chatRoom4 = new ChatRoom().create(Arrays.asList(member1, member5, member6, member7));
            ChatRoom chatRoom5 = new ChatRoom().create(Arrays.asList(member1, member2, member3, member4, member5, member6, member7, member8));

            chatRoomRepository.save(chatRoom1);
            chatRoomRepository.save(chatRoom2);
            chatRoomRepository.save(chatRoom3);
            chatRoomRepository.save(chatRoom4);
            chatRoomRepository.save(chatRoom5);

        }
    }

}
