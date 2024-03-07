package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.SmsService;

/**
 * Implementation of the SmsService interface that sends SMS messages and checks delivery status using either GupshupMock or KayleraMock based on the configured service provider.
 */
@Service
public class SmsServiceImpl implements SmsService {

    /** The service provider for sending SMS messages. */
    @Value("${notification.service.provider}")
    private String serviceProvider;

    /**
     * Sends an SMS message using the configured service provider.
     *
     * @param phoneNumber the phone number to which the SMS should be sent
     * @param message the SMS message
     * @return the base SMS response indicating the status of the SMS sending operation
     */
    @Override
    public BaseSmsResponse sendSms(String phoneNumber, String message) {
        if ("Gupshup".equalsIgnoreCase(serviceProvider)) {
            GupshupMock gupshupMock = new GupshupMock();
            gupshupMock.sendSms(phoneNumber, message);
            return new BaseSmsResponse(true, "SMS sent successfully");
        } else if ("Kaylera".equalsIgnoreCase(serviceProvider)) {
            KayleraMock kayleraMock = new KayleraMock();
            kayleraMock.sendSms(phoneNumber, message);
            return new BaseSmsResponse(true, "SMS sent successfully");
        } else {
            return new BaseSmsResponse(false, "Invalid service provider");
        }
    }

    /**
     * Checks the delivery status of an SMS message using the configured service provider.
     *
     * @param messageId the message ID for which to check the delivery status
     * @return the SMS delivery status indicating the status of the SMS delivery operation
     */
    @Override
    public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
        if ("Gupshup".equalsIgnoreCase(serviceProvider)) {
            GupshupMock gupshupMock = new GupshupMock();
            String response = gupshupMock.getResponseForSms(messageId);
            // Parse the response and return delivery status
            return new SmsDeliveryStatus(true, "SMS delivered successfully");
        } else if ("Kaylera".equalsIgnoreCase(serviceProvider)) {
            KayleraMock kayleraMock = new KayleraMock();
            String response = kayleraMock.getResponseForSms(messageId);
            // Parse the response and return delivery status
            return new SmsDeliveryStatus(false, "SMS delivery failed");
        } else {
            return new SmsDeliveryStatus(false, "Invalid service provider");
        }
    }
}
