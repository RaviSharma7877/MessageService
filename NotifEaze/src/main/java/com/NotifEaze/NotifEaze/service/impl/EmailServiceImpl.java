package com.NotifEaze.NotifEaze.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.EmailService;

/**
 * Implementation of the EmailService interface that sends emails using either GupshupMock or KayleraMock based on the configured service provider.
 */
@Service
public class EmailServiceImpl implements EmailService {

    /** The service provider for sending emails. */
    @Value("${notification.service.provider}")
    private String serviceProvider;

    /** The Gupshup mock for sending emails. */
    @Autowired
    private GupshupMock gupshupMock;

    /** The Kaylera mock for sending emails. */
    @Autowired
    private KayleraMock kayleraMock;

    /**
     * Sends an email using the configured service provider.
     *
     * @param to the recipient email address
     * @param subject the email subject
     * @param body the email body
     * @return the base email response indicating the status of the email sending operation
     */
    @Override
    public BaseEmailResponse sendEmail(String to, String subject, String body) {
        if ("Gupshup".equalsIgnoreCase(serviceProvider)) {
            gupshupMock.sendEmail(to, subject, body);
            return new BaseEmailResponse(true, "Email sent successfully");
        } else if ("Kaylera".equalsIgnoreCase(serviceProvider)) {
            kayleraMock.sendEmail(to, subject, body);
            return new BaseEmailResponse(true, "Email sent successfully");
        } else {
            return new BaseEmailResponse(false, "Invalid service provider");
        }
    }
}
