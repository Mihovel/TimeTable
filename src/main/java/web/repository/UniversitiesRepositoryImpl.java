package web.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UniversitiesRepositoryImpl implements UniversitiesRepository {
    private final JdbcTemplate jdbcTemplate;

    public UniversitiesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getAllUniversities() {
        String sql = "select fullUniversityName from universities";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                (rs.getString("fullUniversityName")));
    }
}
