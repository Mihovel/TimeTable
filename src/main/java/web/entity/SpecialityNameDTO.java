package web.entity;

public class SpecialityNameDTO {
    private Integer facultyId;
    private String specialityName;

    public SpecialityNameDTO() {
    }

    public SpecialityNameDTO(Integer facultyId, String specialityName) {
        this.facultyId = facultyId;
        this.specialityName = specialityName;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}
