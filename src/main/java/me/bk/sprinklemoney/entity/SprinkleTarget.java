package me.bk.sprinklemoney.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class SprinkleTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sprinkle_target_id")
    private Long id;

    private String token;
    private int income = 0;

    @Column(name = "x_user_id")
    private int xUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprinkle_pool_id")
    private SprinklePool sprinklePool;

    public SprinkleTarget(SprinklePool sprinklePool) {
        this.token = sprinklePool.getToken();
        this.sprinklePool = sprinklePool;
    }

    public void addIncome(int income) {
        this.income = income;
    }
}
