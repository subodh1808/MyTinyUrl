package com.test.service;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class MainClass {


    public static void main(String args[]) {
        String digest = null;

        String message = "ABCDF";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] hash = md.digest(message.getBytes("UTF-8"));
            //converting byte array to Hexadecimal
             StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(digest);
        String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
        String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
        System.out.println(encodedUrl);

        UUID uniqueKey = UUID.randomUUID();
        System.out.println (uniqueKey);

        // create five IDs of six, base 62 characters
        for (int i=0; i<5; i++) System.out.println(RandomIdGenerator.GetBase62(6));

        // create five IDs of eight base 36 characters
        for (int i=0; i<5; i++) System.out.println(RandomIdGenerator.GetBase36(8));
    }
}
