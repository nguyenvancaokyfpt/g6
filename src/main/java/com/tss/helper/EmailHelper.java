package com.tss.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tss.model.util.SMTP;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailHelper {
    private SMTP smtp;

    public EmailHelper() {
        smtp = this.loadSMTP();
    }

    public SMTP loadSMTP() {
        Properties properties = new Properties();
        InputStream is = EmailHelper.class.getClassLoader().getResourceAsStream("smtp.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return new SMTP(host, port, username, password);
    }

    public boolean sendEmail(String from, String to, String subject, String content) {
        Properties props = smtp.getProperties();
        // Get the Session object.
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(smtp.getUsername(), smtp.getPassword());
                    }
                });
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field
            message.setFrom(new InternetAddress(from));
            // Set To: header field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Put the content of your message
            message.setText(content);
            // Send message
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendEmail(String to, String subject, String content) {
        return this.sendEmail("admin@metronic.com", to, subject, content);
    }

    public boolean sendHtmlEmail(String from, String to, String subject, String content) {
        Properties props = smtp.getProperties();
        // Get the Session object.
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(smtp.getUsername(), smtp.getPassword());
                    }
                });
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field
            message.setFrom(new InternetAddress(from));
            // Set To: header field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Put the content of your message
            message.setContent(content, "text/html");
            // Send message
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendHtmlEmail(String to, String subject, String content) {
        return this.sendHtmlEmail("admin@metronic.com", to, subject, content);
    }

    public boolean sendResetPasswordEmail(String to, String resetLink) {
        String content = "<!doctype html><html lang=\"en-US\"><head>    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />    <title>Metronic</title>    <meta name=\"description\" content=\"Reset Password Email\">    <style type=\"text/css\">        a:hover {text-decoration: underline !important;}    </style></head><body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">    <!--100% body table-->    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">        <tr>            <td>                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">                    <tr>                        <td style=\"height:80px;\">&nbsp;</td>                    </tr>                    <tr>                        <td style=\"text-align:center;\">                          <a href=\"https://nguyenvancaoky.tech\" title=\"logo\" target=\"_blank\">                            <img height=\"30\" src=\"https://iili.io/sTuVX2.png\" title=\"logo\" alt=\"logo\">                          </a>                        </td>                    </tr>                    <tr>                        <td style=\"height:20px;\">&nbsp;</td>                    </tr>                    <tr>                        <td>                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">                                <tr>                                    <td style=\"height:40px;\">&nbsp;</td>                                </tr>                                <tr>                                    <td style=\"padding:0 35px;\">                                        <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">You have                                            requested to reset your password</h1>                                        <span                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">                                            We cannot simply send you your old password. A unique link to reset your                                            password has been generated for you. To reset your password, click the                                            following link and follow the instructions.                                        </p>                                        <a href=\""
                + resetLink
                + "\"                                            style=\"background:#20e277;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;\">Reset                                            Password</a>                                    </td>                                </tr>                                <tr>                                    <td style=\"height:40px;\">&nbsp;</td>                                </tr>                            </table>                        </td>                    <tr>                        <td style=\"height:20px;\">&nbsp;</td>                    </tr>                    <tr>                        <td style=\"text-align:center;\">                            <p style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">&copy; <strong>metronic.com</strong></p>                        </td>                    </tr>                    <tr>                        <td style=\"height:80px;\">&nbsp;</td>                    </tr>                </table>            </td>        </tr>    </table>    <!--/100% body table--></body></html>";
        return this.sendHtmlEmail(to, "Reset Password", content);
    }

    public boolean sendPassword(String to, String password) {
        String content = "<!doctype html><html lang=\"en-US\"><head>    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />    <title>Metronic</title>    <meta name=\"description\" content=\"Password Email\">    <style type=\"text/css\">        a:hover {text-decoration: underline !important;}    </style></head><body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">    <!--100% body table-->    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\"        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">        <tr>            <td>                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\"                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">                    <tr>                        <td style=\"height:80px;\">&nbsp;</td>                    </tr>                    <tr>                        <td style=\"text-align:center;\">                          <a href=\"https://nguyenvancaoky.tech\" title=\"logo\" target=\"_blank\">                            <img height=\"30\" src=\"https://iili.io/sTuVX2.png\" title=\"logo\" alt=\"logo\">                          </a>                        </td>                    </tr>                    <tr>                        <td style=\"height:20px;\">&nbsp;</td>                    </tr>                    <tr>                        <td>                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">                                <tr>                                    <td style=\"height:40px;\">&nbsp;</td>                                </tr>                                <tr>                                    <td style=\"padding:0 35px;\">                                        <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">You have register account at Metronic</h1>                                        <span                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">                                            This is your account information. Please change your password after login.                                        </p>                                        <a href=\"javascript:void(0);\"                                            style=\"background:#20e277;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;\">"
                + password
                + "</a>                                    </td>                                </tr>                                <tr>                                    <td style=\"height:40px;\">&nbsp;</td>                                </tr>                            </table>                        </td>                    <tr>                        <td style=\"height:20px;\">&nbsp;</td>                    </tr>                    <tr>                        <td style=\"text-align:center;\">                            <p style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">&copy; <strong>metronic.com</strong></p>                        </td>                    </tr>                    <tr>                        <td style=\"height:80px;\">&nbsp;</td>                    </tr>                </table>            </td>        </tr>    </table>    <!--/100% body table--></body></html>";
        return this.sendHtmlEmail(to, "Your account infomation", content);
    }

}
