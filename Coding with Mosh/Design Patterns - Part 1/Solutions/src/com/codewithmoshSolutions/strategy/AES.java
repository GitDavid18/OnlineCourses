package com.codewithmoshSolutions.strategy;

public class AES implements EncryptionAlgorithm {
    @Override
    public String encrypt(String text) {
        System.out.println("Encrypting message using AES");
        return "encryptedText";
    }
}
