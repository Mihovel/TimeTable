package web.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void saveUser(String email, String userName, String password) {
        jdbcTemplate.update("INSERT INTO users (email, userName, password) VALUES (?, ?, ?)",
                email, userName, password);
    }

    @Override
    public boolean checkUser(String userName, String password) {
        String sqlToGetUser = "select count(*) from users where userName=? and password=?";
        Object[] arrayOfParams = new Object[2];
        arrayOfParams[0] = userName;
        arrayOfParams[1] = password;
        Integer count = jdbcTemplate.queryForObject(sqlToGetUser, arrayOfParams, Integer.class);
        if (count == null) {
            System.out.println("DEBUG: count users matching login and password is null");
            return false;
        }
        return count > 0;
    }

    @Override
    public boolean isUserPresent(String email) {
        String sqlParamToCheck = "select count(*) from users where email=?";
        Integer count = jdbcTemplate.queryForObject(sqlParamToCheck, new Object[]{email}, Integer.class);
        if (count == null) {
            System.out.println("DEBUG: user with such email exists");
            return false;
        }
        return count > 0;
    }

    @Override
    public List<Integer> getGroupIdByUserName(String userName) {
        String sqlParam = "select availableGroupId from users where userName=:userName";
        SqlParameterSource param = new MapSqlParameterSource("userName", userName);
        return Arrays.stream(namedParameterJdbcTemplate.queryForObject(sqlParam, param, String.class).split(",")).
                map(Integer::parseInt).collect(Collectors.toList());
    }


}
