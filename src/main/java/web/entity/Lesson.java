package web.entity;

public class Lesson {
    private String durability;
    private String lessonName;
    private String comments;

    public Lesson() {
    }

    public Lesson(String durability, String lessonName, String comments) {
        this.durability = durability;
        this.lessonName = lessonName;
        this.comments = comments;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "durability='" + durability + '\'' +
                ", lessonName='" + lessonName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
