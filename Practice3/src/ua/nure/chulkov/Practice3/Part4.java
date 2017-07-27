package ua.nure.chulkov.Practice3;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Part4 {
    static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(input.getBytes(Charset.forName("Cp1251")));
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
        if (curByte < 10 & curByte >= 0){
            curNumber = "0" + curNumber.substring(curNumber.length()-1);
        }
        return curNumber;
    }
}
