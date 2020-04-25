package web.service;

import org.apache.commons.mail.EmailException;
import web.exeptions.UserAlreadyExistsExeption;

public interface UserService {
    void sendAndSaveAccount(String email) throws UserAlreadyExistsExeption, EmailException;
    boolean checkUser(String login, String password);
}
