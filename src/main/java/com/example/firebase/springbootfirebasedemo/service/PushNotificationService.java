package com.example.firebase.springbootfirebasedemo.service;

import com.example.firebase.springbootfirebasedemo.model.model.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PushNotificationService {

    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    private FCMService fcmService;
    @Autowired
    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    

    public void sendPushNotification(PushNotificationRequest request) {
        try {
            fcmService.sendMessage(getSamplePayloadData(), request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(PushNotificationRequest request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    private Map<String, String> getSamplePayloadData() {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("messageId", "1");
        pushData.put("text", "12");
        pushData.put("user", "1");
        return pushData;
    }



}