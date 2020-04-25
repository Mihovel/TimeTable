package web.entity;

public class UserExistsDTO {
    private String userLogin;
    private boolean isExist;

    public UserExistsDTO(String userLogin, boolean isExist) {
        this.userLogin = userLogin;
        this.isExist = isExist;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
