package me.bk.sprinklemoney.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.bk.sprinklemoney.entity.SprinklePool;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SprinkleMoneyResponseDto {
    @NotNull
    private String token;

    public SprinkleMoneyResponseDto(SprinklePool sprinklePool) {
        this.token = sprinklePool.getToken();
    }
}
