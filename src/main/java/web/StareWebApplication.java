package web;

import org.apache.commons.mail.EmailException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StareWebApplication {

    public static void main(String[] args) throws EmailException {
        SpringApplication.run(StareWebApplication.class);
    }
}