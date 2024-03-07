# NotifEaze

NotifEaze is a communication service that provides SMS, email, and push notification functionalities. It integrates with multiple service providers to send notifications.

## Technologies Used

- Java
- Spring Boot
- MockMvc
- JUnit
- Mockito

## Getting Started

To get started with NotifEaze, follow these steps:

1. Clone the repository:
git clone https://github.com/yourusername/NotifEaze.git
2. Navigate to the project directory:
cd NotifEaze
3. Build the project using Maven:
mvn clean package
4. Run the application:
java -jar target/NotifEaze-1.0.jar

## Usage

### Sending SMS

To send an SMS, make a POST request to `/api/communication/send-sms` with the message content in the request body.

Example request:
POST /send-sms
Content-Type: application/json


### Sending Email

To send an email, make a POST request to `/api/communication/send-email` with the email content in the request body.

Example request:
POST /send-email
Content-Type: application/json

"Test Email"

### Sending Push Notification

To send a push notification, make a POST request to `/api/communication/send-notification` with the notification content in the request body.

Example request:
POST /send-notification
Content-Type: application/json

"Test Push Notification"

## Contributors

- Your Name <sraa7877@gmail.com>


