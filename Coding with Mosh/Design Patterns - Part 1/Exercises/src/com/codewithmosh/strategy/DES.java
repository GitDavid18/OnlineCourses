package com.codewithmosh.strategy;

public class DES implements EncryptionAlgorithm
{
    @Override
    public void encryptMessage(String message) {
        System.out.println("Encrypting message with DES: " + message);
    }
}
