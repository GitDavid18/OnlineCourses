package com.codewithmosh.adapter;

import com.codewithmosh.adapter.Gmail.GmailClient;
import com.codewithmosh.adapter.Gmail.GmailClientAdapter;

public class AdapterMain {
    public static void main(String[] args){
        var client = new EmailClient();
        client.addProvider(new GmailClientAdapter(new GmailClient()));

        client.downloadEmails();
    }
}
