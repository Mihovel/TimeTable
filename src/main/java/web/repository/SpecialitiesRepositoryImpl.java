package web.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialitiesRepositoryImpl implements SpecialitiesRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SpecialitiesRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer getFacultyId(Integer universityId, String facultyName) {
        String getFacultyIdSql = "select id from faculties where universityId=:universityId and facultyName=:facultyName";
        Map<String, Object> mapToGetFacultyId = new HashMap<>();
        mapToGetFacultyId.put("universityId", universityId);
        mapToGetFacultyId.put("facultyName", facultyName);
        SqlParameterSource paramToGetFacultyId = new MapSqlParameterSource(mapToGetFacultyId);
        return namedParameterJdbcTemplate.queryForObject(getFacultyIdSql, paramToGetFacultyId, Integer.class);
    }

    @Override
    public List<String> getAllSpecialitiesOfCurrentFaculty(Integer facultyId) {
        String sql = "select specialityName from specialities where facultyId=:facultyId";
        SqlParameterSource param = new MapSqlParameterSource("facultyId", facultyId);
        return namedParameterJdbcTemplate.query(sql, param, (rs, rowNum) ->
                (rs.getString("specialityName")));
    }
}
