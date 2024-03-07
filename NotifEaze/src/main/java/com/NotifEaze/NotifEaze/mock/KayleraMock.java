package com.NotifEaze.NotifEaze.mock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * A mock implementation of the Kaylera notification service provider for testing purposes.
 */
@Component
public class KayleraMock {
    // Mocked responses for SMS and email
    private static final Map<String, String> SMS_MOCKED_RESPONSES = new HashMap<>();
    private static final Map<String, String> EMAIL_MOCKED_RESPONSES = new HashMap<>();

    static {
        // Initialize mocked responses
        initializeSmsResponses();
        initializeEmailResponses();
    }

    // Initialize mocked responses for SMS
    private static void initializeSmsResponses() {
        SMS_MOCKED_RESPONSES.put("123456", "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "            <root>\n" +
                "                <status>00</status>\n" +
                "                <messageId>123456</messageId>\n" +
                "                <responseMessage>Success</responseMessage>\n" +
                "            </root>");
        SMS_MOCKED_RESPONSES.put("789012", "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "            <root>\n" +
                "                <status>1</status>\n" +
                "                <messageId>789012</messageId>\n" +
                "                <responseMessage>Failed</responseMessage>\n" +
                "            </root>");
    }

    // Initialize mocked responses for email
    private static void initializeEmailResponses() {
        // No email responses currently mocked
    }

    /**
     * Method to send a mocked SMS.
     *
     * @param phoneNumber The phone number to send the SMS to.
     * @param message     The SMS message.
     * @return A string indicating the success or failure of the operation.
     */
    public String sendSms(String phoneNumber, String message) {
        // Hardcode a response for SMS
        return "SMS sent to " + phoneNumber + ": " + message;
    }

    /**
     * Method to send a mocked email.
     *
     * @param email   The recipient's email address.
     * @param subject The email subject.
     * @param message The email message.
     * @return A string indicating the success or failure of the operation.
     */
    public String sendEmail(String email, String subject, String message) {
        // Hardcode a response for email
        return "Email sent to " + email + " with subject '" + subject + "': " + message;
    }

    /**
     * Method to send a mocked push notification.
     *
     * @param deviceId The recipient's device ID.
     * @param message  The push notification message.
     * @return A string indicating the success or failure of the operation.
     */
    public String sendPushNotification(String deviceId, String message) {
        // Hardcode a response for push notification
        return "Push notification sent to device " + deviceId + ": " + message;
    }

    /**
     * Method to get a mocked response for an SMS.
     *
     * @param messageId The message ID for the SMS.
     * @return The mocked response for the SMS.
     */
    public String getResponseForSms(String messageId) {
        return SMS_MOCKED_RESPONSES.get(messageId);
    }

    /**
     * Method to get a mocked response for an email.
     *
     * @param emailId The email ID for the email.
     * @return The mocked response for the email.
     */
    public String getResponseForEmail(String emailId) {
        return EMAIL_MOCKED_RESPONSES.get(emailId);
    }
}
