package web.entity;

public class GroupNameAndSpecIdDTO {
    private String groupName;
    private Integer specialityId;

    public GroupNameAndSpecIdDTO() {
    }

    public GroupNameAndSpecIdDTO(String groupName, Integer specialityId) {
        this.groupName = groupName;
        this.specialityId = specialityId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }
}
