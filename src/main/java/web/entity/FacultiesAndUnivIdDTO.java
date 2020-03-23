package web.entity;

import java.util.List;

public class FacultiesAndUnivIdDTO {
    private Integer universityId;
    private List<String> facultiesNames;

    public FacultiesAndUnivIdDTO() {
    }

    public FacultiesAndUnivIdDTO(Integer universityId, List<String> facultiesNames) {
        this.universityId = universityId;
        this.facultiesNames = facultiesNames;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public List<String> getFacultiesNames() {
        return facultiesNames;
    }

    public void setFacultiesNames(List<String> facultiesNames) {
        this.facultiesNames = facultiesNames;
    }
}
