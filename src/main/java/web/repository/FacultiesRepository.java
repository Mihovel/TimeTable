package web.repository;

import java.util.List;

public interface FacultiesRepository {
    Integer getUniversityId(String universityName);
    List<String> getAllFacultiesOfCurrentUniversity(Integer universityId);
}
