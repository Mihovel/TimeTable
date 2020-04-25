package web.repository;

import web.entity.TimeTableDTO;

import java.util.List;

public interface TimeTableRepository {
    void addTimeTable(TimeTableDTO timeTableDTO);
    List<TimeTableDTO> selectTimeTable(List<Integer> groupIds);
    void updateTimeTable(TimeTableDTO timeTableDTO);
}
