package web.repository;

import java.util.List;

public interface SpecialitiesRepository {
    Integer getFacultyId(Integer universityId, String facultyName);
    List<String> getAllSpecialitiesOfCurrentFaculty(Integer facultyId);
}
