package web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.repository.EmailRepository;
import web.service.EmailService;
import web.service.EmailServiceImpl;

@Configuration
public class ServiceConfiguration {

    @Bean
    public EmailService emailService(EmailRepository emailRepository) {
        return new EmailServiceImpl(emailRepository);
    }
}
