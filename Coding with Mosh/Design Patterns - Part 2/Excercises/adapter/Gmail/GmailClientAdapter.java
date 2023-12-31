package com.codewithmosh.adapter.Gmail;

import com.codewithmosh.adapter.EmailProvider;

public class GmailClientAdapter implements EmailProvider {

    private GmailClient gmailClient;

    public GmailClientAdapter(GmailClient gmailClient) {
        this.gmailClient = gmailClient;
    }

    @Override
    public void downloadEmails() {
        gmailClient.connect();
        gmailClient.getEmails();
        gmailClient.disconnect();
    }
}
