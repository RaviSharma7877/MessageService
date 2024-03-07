package com.NotifEaze.NotifEaze.controller;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/communication")
public class CommunicationController {

    /**
     * Endpoint to send an SMS message.
     *
     * @param message The SMS message to send.
     * @return The response entity containing the status of the SMS sending operation.
     */
    @PostMapping("/send-sms")
    public ResponseEntity<BaseSmsResponse> sendSms(@RequestBody String message) {
        
        BaseSmsResponse response = new BaseSmsResponse(true, "SMS sent successfully");
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint to send an email message.
     *
     * @param message The email message to send.
     * @return The response entity containing the status of the email sending operation.
     */
    @PostMapping("/send-email")
    public ResponseEntity<BaseEmailResponse> sendEmail(@RequestBody String message) {
        
        BaseEmailResponse response = new BaseEmailResponse(true, "Email sent successfully");
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint to send a push notification message.
     *
     * @param message The push notification message to send.
     * @return The response entity containing the status of the push notification sending operation.
     */
    @PostMapping("/send-notification")
    public ResponseEntity<BasePushNotificationResponse> sendNotification(@RequestBody String message) {
        
        BasePushNotificationResponse response = new BasePushNotificationResponse(true, "Push notification sent successfully");
        return ResponseEntity.ok(response);
    }
}
