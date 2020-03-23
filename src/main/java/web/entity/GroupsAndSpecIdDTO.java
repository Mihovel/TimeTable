package web.entity;

import java.util.List;

public class GroupsAndSpecIdDTO {
    private Integer specialityId;
    private List<String> groupsNames;

    public GroupsAndSpecIdDTO() {
    }

    public GroupsAndSpecIdDTO(Integer specialityId, List<String> groupsNames) {
        this.specialityId = specialityId;
        this.groupsNames = groupsNames;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public List<String> getGroupsNames() {
        return groupsNames;
    }

    public void setGroupsNames(List<String> groupsNames) {
        this.groupsNames = groupsNames;
    }
}
