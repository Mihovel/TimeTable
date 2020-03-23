package web.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsRepositoryImpl implements GroupsRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GroupsRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer getSpecialityId(Integer facultyId, String specialityName) {
        String getSpecialityIdSql = "select id from specialities where facultyId=:facultyId and specialityName=:specialityName";
        Map<String, Object> mapToGetSpecialityId = new HashMap<>();
        mapToGetSpecialityId.put("facultyId", facultyId);
        mapToGetSpecialityId.put("specialityName", specialityName);
        SqlParameterSource paramToGetSpecialityId = new MapSqlParameterSource(mapToGetSpecialityId);
        return namedParameterJdbcTemplate.queryForObject(getSpecialityIdSql, paramToGetSpecialityId, Integer.class);
    }

    @Override
    public Integer getGroupId(String groupName, Integer specialityId) {
        String sql = "select id from groups where specialityId=:specialityId and groupName=:groupName";
        Map<String, Object> mapToGetGroupId = new HashMap<>();
        mapToGetGroupId.put("specialityId", specialityId);
        mapToGetGroupId.put("groupName", groupName);
        SqlParameterSource param = new MapSqlParameterSource(mapToGetGroupId);
        return namedParameterJdbcTemplate.queryForObject(sql, param, Integer.class);
    }

    @Override
    public List<String> getAllGroupsOfCurrentSpeciality(Integer specialityId) {
        String sql = "select groupName from groups where specialityId=:specialityId";
        SqlParameterSource param = new MapSqlParameterSource("specialityId", specialityId);
        return namedParameterJdbcTemplate.query(sql, param, (rs, rowNum) ->
                (rs.getString("groupName")));
    }
}
