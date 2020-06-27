package me.bk.sprinklemoney.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.bk.sprinklemoney.utils.TokenGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "chat_room")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    @Column(name = "x_room_id")
    private String xRoomId;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
    private List<ChatMember> chatMembers = new ArrayList<>();

    public ChatRoom create(List<Member> members) {
        xRoomId = TokenGenerator.generateChatRoomId();
        for (Member member : members) {
            ChatMember chatMember = new ChatMember();
            chatMember.addMember(member, this);
            chatMembers.add(chatMember);
        }
        return this;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL)
    private List<SprinklePool> sprinklePools = new ArrayList<>();
}
