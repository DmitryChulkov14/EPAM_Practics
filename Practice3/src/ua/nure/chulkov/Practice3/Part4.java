package ua.nure.chulkov.Practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
    static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(input.getBytes());
        byte[] hash = messageDigest.digest();
        StringBuilder result = new StringBuilder();
        for (byte curByte : hash) {
            String curNumber = getHexNumberFromByteValue(curByte);
            result.append(curNumber.toUpperCase());
        }
        return result.toString();
    }

    private static String getHexNumberFromByteValue(byte curByte) {
        String curNumber = Integer.toHexString(curByte);
        if (curByte < 0){
            curNumber = curNumber.substring(curNumber.length()-2);
        }
        return curNumber;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
    }
}
