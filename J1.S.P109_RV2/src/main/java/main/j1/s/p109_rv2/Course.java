package main.j1.s.p109_rv2;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;

    public Course() {
        this.courseId = "";
        this.courseName = "";
        this.credits = 0;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? "" : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? "" : courseName.trim();
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    // Basic info line for list printing
    public String basicInfo() {
        return String.format("%s-%s-%d", getCourseId(), getCourseName(), getCredits());
    }

    // Detailed view for searching/updating
    public void printDetail() {
        System.out.println("Course ID: " + getCourseId());
        System.out.println("Course name: " + getCourseName());
        System.out.println("Credits: " + getCredits());
    }
}
