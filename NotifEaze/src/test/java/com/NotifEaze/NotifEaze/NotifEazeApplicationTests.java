package com.NotifEaze.NotifEaze;

import com.NotifEaze.NotifEaze.controller.CommunicationController;
import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CommunicationController.class)
@AutoConfigureMockMvc
class CommunicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommunicationController communicationController;

    @Test
    void sendSms() throws Exception {
        BaseSmsResponse smsResponse = new BaseSmsResponse(true, "SMS sent successfully");
        ResponseEntity<BaseSmsResponse> responseEntity = new ResponseEntity<>(smsResponse, HttpStatus.OK);
        when(communicationController.sendSms(any())).thenReturn(responseEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/communication/send-sms")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Test SMS"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("SMS sent successfully"));
    }

    @Test
    void sendEmail() throws Exception {
        BaseEmailResponse emailResponse = new BaseEmailResponse(true, "Email sent successfully");
        ResponseEntity<BaseEmailResponse> responseEntity = new ResponseEntity<>(emailResponse, HttpStatus.OK);
        when(communicationController.sendEmail(any())).thenReturn(responseEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/communication/send-email")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Test Email"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Email sent successfully"));
    }

    @Test
    void sendNotification() throws Exception {
        BasePushNotificationResponse notificationResponse = new BasePushNotificationResponse(true, "Push notification sent successfully");
        ResponseEntity<BasePushNotificationResponse> responseEntity = new ResponseEntity<>(notificationResponse, HttpStatus.OK);
        when(communicationController.sendNotification(any())).thenReturn(responseEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/communication/send-notification")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Test Push Notification"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Push notification sent successfully"));
    }
}
