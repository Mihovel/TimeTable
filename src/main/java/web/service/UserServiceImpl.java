package web.service;

import org.apache.commons.mail.EmailException;
import org.springframework.transaction.annotation.Transactional;
import web.exeptions.UserAlreadyExistsExeption;
import web.repository.UserRepository;
import web.util.EmailUtil;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(transactionManager = "mainTransactionManager")
    public void sendAndSaveAccount(String email) throws UserAlreadyExistsExeption, EmailException {
        String userName = getUserName(email);
        if (userRepository.isUserPresent(email)) {
            throw new UserAlreadyExistsExeption();
        }
        String password = generatePassword();
        userRepository.saveUser(email, userName, password);
        EmailUtil.send(email, userName, password);
    }

    @Override
    public boolean checkUser(String login, String password) {
        return userRepository.checkUser(login, password);
    }

    private String generatePassword() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "").substring(0, 8);
    }

    private String getUserName(String email) {
        return email.substring(0, email.indexOf("@"));
    }
}
