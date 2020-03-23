package web.entity;

import java.util.List;

public class SpecialitiesAndFacIdDTO {
    private Integer facultyId;
    private List<String> specialitiesNames;

    public SpecialitiesAndFacIdDTO() {
    }

    public SpecialitiesAndFacIdDTO(Integer facultyId, List<String> specialitiesNames) {
        this.facultyId = facultyId;
        this.specialitiesNames = specialitiesNames;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setSpecialitiesId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public List<String> getSpecialitiesNames() {
        return specialitiesNames;
    }

    public void setSpecialitiesNames(List<String> specialitiesNames) {
        this.specialitiesNames = specialitiesNames;
    }
}
