package web.entity;

import java.util.Date;
import java.util.List;

public class TimeTableDTO {
    private Date currentMondayDate;
    private List<Lesson> mondayLessons;
    private List<Lesson> tuesdayLessons;
    private List<Lesson> wednesdayLessons;
    private List<Lesson> thursdayLessons;
    private List<Lesson> fridayLessons;
    private int version;
    private String author;
    private Integer groupId;

    public TimeTableDTO() {
    }

    public TimeTableDTO(Date currentMondayDate, List<Lesson> mondayLessons, List<Lesson> tuesdayLessons,
                        List<Lesson> wednesdayLessons, List<Lesson> thursdayLessons, List<Lesson> fridayLessons) {
        this.currentMondayDate = currentMondayDate;
        this.mondayLessons = mondayLessons;
        this.tuesdayLessons = tuesdayLessons;
        this.wednesdayLessons = wednesdayLessons;
        this.thursdayLessons = thursdayLessons;
        this.fridayLessons = fridayLessons;
    }

    public TimeTableDTO(Date currentMondayDate, List<Lesson> mondayLessons, List<Lesson> tuesdayLessons,
                        List<Lesson> wednesdayLessons, List<Lesson> thursdayLessons, List<Lesson> fridayLessons,
                        int version, String author, Integer groupId) {
        this.currentMondayDate = currentMondayDate;
        this.mondayLessons = mondayLessons;
        this.tuesdayLessons = tuesdayLessons;
        this.wednesdayLessons = wednesdayLessons;
        this.thursdayLessons = thursdayLessons;
        this.fridayLessons = fridayLessons;
        this.version = version;
        this.author = author;
        this.groupId = groupId;
    }

    public Date getCurrentMondayDate() {
        return currentMondayDate;
    }

    public void setCurrentMondayDate(Date currentMondayDate) {
        this.currentMondayDate = currentMondayDate;
    }

    public List<Lesson> getMondayLessons() {
        return mondayLessons;
    }

    public void setMondayLessons(List<Lesson> mondayLessons) {
        this.mondayLessons = mondayLessons;
    }

    public List<Lesson> getTuesdayLessons() {
        return tuesdayLessons;
    }

    public void setTuesdayLessons(List<Lesson> tuesdayLessons) {
        this.tuesdayLessons = tuesdayLessons;
    }

    public List<Lesson> getWednesdayLessons() {
        return wednesdayLessons;
    }

    public void setWednesdayLessons(List<Lesson> wednesdayLessons) {
        this.wednesdayLessons = wednesdayLessons;
    }

    public List<Lesson> getThursdayLessons() {
        return thursdayLessons;
    }

    public void setThursdayLessons(List<Lesson> thursdayLessons) {
        this.thursdayLessons = thursdayLessons;
    }

    public List<Lesson> getFridayLessons() {
        return fridayLessons;
    }

    public void setFridayLessons(List<Lesson> fridayLessons) {
        this.fridayLessons = fridayLessons;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "TimeTableDTO{" +
                "currentMondayDate=" + currentMondayDate +
                ", mondayLessons=" + mondayLessons +
                ", tuesdayLessons=" + tuesdayLessons +
                ", wednesdayLessons=" + wednesdayLessons +
                ", thursdayLessons=" + thursdayLessons +
                ", fridayLessons=" + fridayLessons +
                ", version=" + version +
                ", author='" + author + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}

