package web.repository;

public interface EmailRepository {
    void saveUser(String email, String userName, String password);
    boolean checkUser(String login, String password);
    boolean isUserPresent(String login);
}
