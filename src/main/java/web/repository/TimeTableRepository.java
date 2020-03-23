package web.repository;

import web.entity.TimeTableDTO;

public interface TimeTableRepository {
    void addTimeTable(TimeTableDTO timeTableDTO);
    TimeTableDTO selectTimeTable();
    void updateTimeTable(TimeTableDTO timeTableDTO);
}
