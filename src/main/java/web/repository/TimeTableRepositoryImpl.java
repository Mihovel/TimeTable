package web.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import web.entity.Lesson;
import web.entity.TimeTableDTO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TimeTableRepositoryImpl implements TimeTableRepository {
    private final JdbcTemplate jdbcTemplate;

    public TimeTableRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addTimeTable(TimeTableDTO timeTableDTO) {
        try {
            jdbcTemplate.update(
                    "INSERT INTO timetable (currentMondayDate, timetableMonday, timetableTuesday," +
                            "timetableWednesday, timetableThursday, timetableFriday, version, author, groupId) VALUES" +
                            " (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new Date(),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getMondayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getTuesdayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getWednesdayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getThursdayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getFridayLessons()),
                    1, "Misha", 1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TimeTableDTO selectTimeTable() {
        String sql = "SELECT * FROM timetable";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, (rs, rowNum) ->
        {
            try {
                return new TimeTableDTO(
                        rs.getDate("currentMondayDate"),
                        new ObjectMapper().readValue(rs.getString("timetableMonday"),
                                new TypeReference<List<Lesson>>() {
                                }),
                        new ObjectMapper().readValue(rs.getString("timetableTuesday"),
                                new TypeReference<List<Lesson>>() {
                                }),
                        new ObjectMapper().readValue(rs.getString("timetableWednesday"),
                                new TypeReference<List<Lesson>>() {
                                }),
                        new ObjectMapper().readValue(rs.getString("timetableThursday"),
                                new TypeReference<List<Lesson>>() {
                                }),
                        new ObjectMapper().readValue(rs.getString("timetableFriday"),
                                new TypeReference<List<Lesson>>() {
                                }),
                        rs.getInt("version"),
                        rs.getString("author"),
                        rs.getInt("groupId")
                );
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    @Override
    public void updateTimeTable(TimeTableDTO timeTableDTO) {

        try {
            jdbcTemplate.update("update timetable set currentMondayDate = ?, timetableMonday = ?," +
                            "timetableTuesday =?, timetableWednesday = ?, timetableThursday = ?, timetableFriday = ?," +
                            "version = ?, author = ? where version = 1",
                    new Date(),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getMondayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getTuesdayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getWednesdayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getThursdayLessons()),
                    new ObjectMapper().writeValueAsString(timeTableDTO.getFridayLessons()),
                    1, "Misha");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}



