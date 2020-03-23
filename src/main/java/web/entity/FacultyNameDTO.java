package web.entity;

public class FacultyNameDTO {
    private Integer universityId;
    private String facultyName;

    public FacultyNameDTO() {
    }

    public FacultyNameDTO(Integer universityId, String facultyName) {
        this.universityId = universityId;
        this.facultyName = facultyName;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
