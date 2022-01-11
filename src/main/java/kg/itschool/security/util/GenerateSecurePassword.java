package kg.itschool.security.util;

import java.security.SecureRandom;
import java.util.Random;

public class GenerateSecurePassword {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generatePassword(int length) {
        char[] randomSymbols = new char[length];
        for (int i = 0; i < length; i++) {
            randomSymbols[i] = ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
        }
        return new String(randomSymbols);
    }
}