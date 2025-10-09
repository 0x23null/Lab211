package main.j1.s.p109_rv2;

public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? "" : platform.trim();
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors == null ? "" : instructors.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? "" : note.trim();
    }

    @Override
    public void printDetail() {
        super.printDetail();
        System.out.println("Platform: " + getPlatform());
        System.out.println("Instructors: " + getInstructors());
        System.out.println("Note: " + getNote());
    }

    public String onlineInfo() {
        return String.format("%s-%s-%d-%s-%s-%s",
                getCourseId(), getCourseName(), getCredits(), getPlatform(), getInstructors(), getNote());
    }
}
