package com.btg.investment.funds.services.impl;


import com.btg.investment.funds.services.INotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Override
    public void sendEmail(String email, String message) {
        System.out.println("SMS sent to " + email);
    }

    @Override
    public void sendSMS(String phone, String message) {

        System.out.println("SMS sent to " + phone);
    }
}
