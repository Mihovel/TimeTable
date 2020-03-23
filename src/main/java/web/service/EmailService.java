package web.service;

import web.exeptions.UserAlreadyExistsExeption;

public interface EmailService {
    void sendAndSaveAccount(String email) throws UserAlreadyExistsExeption;
    boolean checkUser(String login, String password);
}
