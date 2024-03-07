package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.PushNotificationService;

/**
 * Implementation of the PushNotificationService interface that sends push notifications using either GupshupMock or KayleraMock based on the configured service provider.
 */
@Service
public class PushNotificationServiceImpl implements PushNotificationService {

    /** The service provider for sending push notifications. */
    @Value("${notification.service.provider}")
    private String serviceProvider;

    /**
     * Sends a push notification using the configured service provider.
     *
     * @param fcmToken the FCM token of the device
     * @param message the push notification message
     * @return the base push notification response indicating the status of the push notification sending operation
     */
    @Override
    public BasePushNotificationResponse sendNotification(String fcmToken, String message) {
        if ("Gupshup".equalsIgnoreCase(serviceProvider)) {
            GupshupMock gupshupMock = new GupshupMock();
            gupshupMock.sendPushNotification(fcmToken, message);
            return new BasePushNotificationResponse(true, "Push notification sent successfully");
        } else if ("Kaylera".equalsIgnoreCase(serviceProvider)) {
            KayleraMock kayleraMock = new KayleraMock();
            kayleraMock.sendPushNotification(fcmToken, message);
            return new BasePushNotificationResponse(true, "Push notification sent successfully");
        } else {
            return new BasePushNotificationResponse(false, "Invalid service provider");
        }
    }
}
