package web.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
    public static void send(String email, String userName, String password) throws EmailException {
        Email simpleEmail = new SimpleEmail();
        simpleEmail.setHostName("smtp.yandex.com");
        simpleEmail.setSmtpPort(4651);
        simpleEmail.setAuthenticator(new DefaultAuthenticator("timetable-assistant@yandex.ru", "102030aab"));
        simpleEmail.setSSLOnConnect(true);
        simpleEmail.setSubject("TestMail");
        simpleEmail.setFrom("timetable-assistant@yandex.ru");
        simpleEmail.setMsg("Your login: " + userName + "\n" + "Your password: " + password);
        simpleEmail.addTo(email);
        String send = simpleEmail.send();
        System.out.println("send = " + send);
    }
}
