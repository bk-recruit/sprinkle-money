package me.bk.sprinklemoney.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.bk.sprinklemoney.dto.SprinkleMoneyRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "sprinkle_pool")
public class SprinklePool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sprinkle_pool_id")
    private Long id;

    @Column(name = "sprinkled_x_user_id")
    private int sprinkledXUserId;

    @Column(name = "x_room_id")
    private String xRoomId;

    private String token;

    private int amount;
    private int targetCount;

    public SprinklePool(ChatRoom chatRoom, SprinkleMoneyRequestDto sprinkleMoneyRequestDto, String token) {
        this.xRoomId = chatRoom.getXRoomId();
        this.amount = sprinkleMoneyRequestDto.getAmount();
        this.targetCount = sprinkleMoneyRequestDto.getTargetCount();
        this.token = token;
        this.chatRoom = chatRoom;
    }

    public void addSprinkleTarget() {
        int remainAmount = this.amount;
        for (int i = 0; i < this.targetCount; i++) {
            int dividedAmount = remainAmount / this.targetCount;
            remainAmount = remainAmount - dividedAmount;
            if (i == this.targetCount - 1 && remainAmount > 0) {
                dividedAmount += remainAmount;
            }
            SprinkleTarget sprinkleTarget = new SprinkleTarget(this);
            sprinkleTarget.addIncome(dividedAmount);
            sprinkleTargets.add(sprinkleTarget);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @OneToMany(mappedBy = "sprinklePool", cascade = CascadeType.ALL)
    List<SprinkleTarget> sprinkleTargets = new ArrayList<>();
}
