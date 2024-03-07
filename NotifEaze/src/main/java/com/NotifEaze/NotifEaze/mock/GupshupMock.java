package com.NotifEaze.NotifEaze.mock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * A mock implementation of a notification service provider (e.g., Gupshup) for testing purposes.
 */
@Component
public class GupshupMock {

    // Mocked responses for SMS, email, and push notifications
    private static final Map<String, String> SMS_MOCKED_RESPONSES = new HashMap<>();
    private static final Map<String, String> EMAIL_MOCKED_RESPONSES = new HashMap<>();
    private static final Map<String, String> PN_MOCKED_RESPONSES = new HashMap<>();

    static {
        // Initialize mocked responses
        initializeSmsResponses();
        initializeEmailResponses();
        initializePushNotificationResponses();
    }

    // Initialize mocked responses for SMS
    private static void initializeSmsResponses() {
        SMS_MOCKED_RESPONSES.put("MessageId1", "{\"success\":true,\"messageId\":\"MessageId1\",\"providerResponse\":\"SMS sent successfully.\"}");
        SMS_MOCKED_RESPONSES.put("MessageId2", "{\"success\":false,\"messageId\":\"MessageId2\",\"providerResponse\":\"Network Failure!\"}");
    }

    // Initialize mocked responses for email
    private static void initializeEmailResponses() {
        EMAIL_MOCKED_RESPONSES.put("Email1", "{\"status\":\"success\",\"message\":\"Email sent successfully\",\"timestamp\":\"2023-12-01T14:30:00Z\",\"data\":{\"email_id\":\"test1@gmail.com\",\"recipient\":\"user@example.com\",\"subject\":\"Sample Email Subject\"}}");
    }

    // Initialize mocked responses for push notifications
    private static void initializePushNotificationResponses() {
        PN_MOCKED_RESPONSES.put("FCMToken1", "{\"status\":\"success\",\"message\":\"Push notification sent successfully\",\"timestamp\":\"2023-12-01T14:30:00Z\",\"data\":{\"notification_id\":\"123456789\",\"recipient\":\"user123\",\"platform\":\"iOS\"}}");
    }

    /**
     * Method to send a mocked SMS.
     * @param phoneNumber The phone number to send the SMS to.
     * @param message The SMS message.
     */
    public static void sendSms(String phoneNumber, String message) {
        String response = "{\"status\":\"success\",\"message\":\"SMS sent successfully\",\"timestamp\":\"2023-12-01T14:30:00Z\",\"data\":{\"messageId\":\"MessageId1\",\"providerResponse\":\"SMS sent successfully.\"}}";
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
        System.out.println("Response: " + response);
    }

    /**
     * Method to send a mocked email.
     * @param email The recipient's email address.
     * @param subject The email subject.
     * @param message The email message.
     */
    public static void sendEmail(String email, String subject, String message) {
        String response = "{\"status\":\"success\",\"message\":\"Email sent successfully\",\"timestamp\":\"2023-12-01T14:30:00Z\",\"data\":{\"email_id\":\"" + email + "\",\"recipient\":\"user@example.com\",\"subject\":\"" + subject + "\"}}";
        System.out.println("Sending email to " + email + " with subject '" + subject + "': " + message);
        System.out.println("Response: " + response);
    }

    /**
     * Method to send a mocked push notification.
     * @param deviceId The recipient's device ID.
     * @param message The push notification message.
     */
    public static void sendPushNotification(String deviceId, String message) {
        String response = "{\"status\":\"success\",\"message\":\"Push notification sent successfully\",\"timestamp\":\"2023-12-01T14:30:00Z\",\"data\":{\"notification_id\":\"123456789\",\"recipient\":\"" + deviceId + "\",\"platform\":\"Android\"}}";
        System.out.println("Sending push notification to device " + deviceId + ": " + message);
        System.out.println("Response: " + response);
    }

    /**
     * Method to get a mocked response for an SMS.
     * @param messageId The message ID for the SMS.
     * @return The mocked response for the SMS.
     */
    public String getResponseForSms(String messageId) {
        return SMS_MOCKED_RESPONSES.get(messageId);
    }

    /**
     * Method to get a mocked response for an email.
     * @param emailId The email ID for the email.
     * @return The mocked response for the email.
     */
    public String getResponseForEmail(String emailId) {
        return EMAIL_MOCKED_RESPONSES.get(emailId);
    }

    /**
     * Method to get a mocked response for a push notification.
     * @param deviceId The device ID for the push notification.
     * @return The mocked response for the push notification.
     */
    public String getResponseForPushNotification(String deviceId) {
        return PN_MOCKED_RESPONSES.get(deviceId);
    }
}
