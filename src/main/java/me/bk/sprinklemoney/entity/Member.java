package me.bk.sprinklemoney.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "x_user_id")
    private int xUserId;

    public int getXUserId() {
        return this.xUserId;
    }

    private String email;
    private String name;

    public Member(int xUserId, String email, String name) {
        this.xUserId = xUserId;
        this.email = email;
        this.name = name;
    }

    @OneToMany(mappedBy = "member")
    private List<ChatMember> chatMembers = new ArrayList<>();
}
