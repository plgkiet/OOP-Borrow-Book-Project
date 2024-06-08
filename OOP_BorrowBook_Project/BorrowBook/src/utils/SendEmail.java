package utils;


import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public static void sendEmail(String receiver, String filePath) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // For Gmail
        properties.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("trankhanhbinh1234@gmail.com", "rqgq bkhc eneg trhi");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("trankhanhbinh1234@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
            message.setSubject("ĐĂNG KÝ THÀNH CÔNG");
            message.setText("This is a test email with attachment.");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            // Set the email body
            messageBodyPart.setText("Bạn đã đăng ký thành công tài khoản thư viện. Mã QR đính kèm trong email là để đăng nhập. Đây là mã QR đăng nhập của riêng bạn, vui lòng không chia sẻ với bất kì ai.");
            multipart.addBodyPart(messageBodyPart);

            // Attachment part
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath); // File to attach
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("QR Code");
            multipart.addBodyPart(attachmentBodyPart);

            // Set the complete message parts
            message.setContent(multipart);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
