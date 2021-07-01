package com.codewithmosh.strategy;

public class AES implements EncryptionAlgorithm{
    @Override
    public void encryptMessage(String message) {
        System.out.println("Encrypting message with AES: " + message);
    }
}
