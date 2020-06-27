package me.bk.sprinklemoney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class SprinkleMoneyRequestDto {
    @NotNull
    private int amount;
    @NotNull
    private int targetCount;

}
