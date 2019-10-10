package com.test.service;

public class KeyManagementService {

    public static String getNewKey(){
        String key = null;
        key = RandomIdGenerator.GetBase36(6);
        return key;
    }
}
