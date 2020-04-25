package web.repository;

import java.util.List;

public interface UserRepository {
    void saveUser(String email, String userName, String password);
    boolean checkUser(String login, String password);
    boolean isUserPresent(String login);
    List<Integer> getGroupIdByUserName(String userName);
}
