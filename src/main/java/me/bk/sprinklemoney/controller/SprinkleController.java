package me.bk.sprinklemoney.controller;

import me.bk.sprinklemoney.dto.SprinkleMoneyRequestDto;
import me.bk.sprinklemoney.dto.SprinkleMoneyResponseDto;
import me.bk.sprinklemoney.entity.SprinklePool;
import me.bk.sprinklemoney.exception.DefaultExceptionHandler;
import me.bk.sprinklemoney.service.SprinkleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SprinkleController {

    @Autowired
    private SprinkleService sprinkleService;

    @PostMapping("/api/sprinkleMoney")
    public List<SprinkleMoneyResponseDto> sprinkleMoney(@RequestHeader(value = "X-USER-ID") int xUserId,
                                                        @RequestHeader(value = "X-ROOM-ID") String xRoomId,
                                                        @RequestBody @Valid SprinkleMoneyRequestDto sprinkleMoneyRequestDto) throws DefaultExceptionHandler {

        SprinklePool sprinklePool = sprinkleService.sprinkleMoney(xUserId, xRoomId, sprinkleMoneyRequestDto);
        List<SprinkleMoneyResponseDto> responseDtos = new ArrayList<>();
        responseDtos.add(new SprinkleMoneyResponseDto(sprinklePool));
        return responseDtos;
    }

}
