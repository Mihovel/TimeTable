package web.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class FacultiesRepositoryImpl implements FacultiesRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FacultiesRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer getUniversityId(String universityName) {
        String getUniversityIdSql = "select id from universities where fullUniversityName=:universityName";
        SqlParameterSource paramToGetUniversityId = new MapSqlParameterSource("universityName", universityName);
        return namedParameterJdbcTemplate.queryForObject(getUniversityIdSql, paramToGetUniversityId, Integer.class);
    }

    @Override
    public List<String> getAllFacultiesOfCurrentUniversity(Integer universityId) {
        String sql = "select facultyName from faculties where universityId=:universityId";
        SqlParameterSource param = new MapSqlParameterSource("universityId", universityId);
        return namedParameterJdbcTemplate.query(sql, param, (rs, rowNum) ->
                (rs.getString("facultyName")));
    }
}
