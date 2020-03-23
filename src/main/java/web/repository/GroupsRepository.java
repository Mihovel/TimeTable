package web.repository;

import java.util.List;

public interface GroupsRepository {
    Integer getSpecialityId(Integer facultyId, String specialityName);
    Integer getGroupId(String groupName, Integer specialityId);
    List<String> getAllGroupsOfCurrentSpeciality(Integer specialityId);
}
