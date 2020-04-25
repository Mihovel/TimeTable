package web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.repository.UserRepository;
import web.service.UserService;
import web.service.UserServiceImpl;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UserService emailService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
