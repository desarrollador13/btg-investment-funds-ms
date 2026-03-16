package com.btg.investment.funds.services;

public interface INotificationService {

    void sendEmail(String email, String message);
    void sendSMS(String phone, String message);
}
