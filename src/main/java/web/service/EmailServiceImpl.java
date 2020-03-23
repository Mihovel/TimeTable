package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.exeptions.UserAlreadyExistsExeption;
import web.repository.EmailRepository;
import web.util.EmailUtil3;

import java.util.UUID;

public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    @Transactional(transactionManager = "mainTransactionManager")
    public void sendAndSaveAccount(String email) throws UserAlreadyExistsExeption {
        String userName = getUserName(email);
        if (emailRepository.isUserPresent(email)) {
            throw new UserAlreadyExistsExeption();
        }
        String password = generatePassword();
        emailRepository.saveUser(email, userName, password);
        EmailUtil3.send(email, userName, password);
    }

    @Override
    public boolean checkUser(String login, String password) {
        return emailRepository.checkUser(login, password);
    }

    private String generatePassword() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "").substring(0, 8);
    }

    private String getUserName(String email) {
        return email.substring(0, email.indexOf("@"));
    }
}
