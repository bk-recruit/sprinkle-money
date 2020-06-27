package me.bk.sprinklemoney.utils;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TokenGenerator {

    private static final int SPRINKLE_REQUEST_TOKEN_LENGTH = 3;
    private static final int ROOM_ID_TOKEN_LENGTH = 5;
    private static final String TOKEN_RANDOM_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

    public static String generateSprinkleRequestToken() {
        return NanoIdUtils.randomNanoId(new Random(), TOKEN_RANDOM_CHARS.toCharArray(), SPRINKLE_REQUEST_TOKEN_LENGTH);
    }

    public static String generateChatRoomId() {
        return NanoIdUtils.randomNanoId(new Random(), TOKEN_RANDOM_CHARS.toCharArray(), ROOM_ID_TOKEN_LENGTH);
    }

}
