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
    public void inputAll() {
        super.inputAll();
        while (true) {
            String p = Validator.getStringInput("Platform: ");
            if (p.isEmpty()) {
                System.out.println("Data input is  invalid");
                continue;
            }
            setPlatform(p);
            break;
        }
        String ins = Validator.getStringInput("Instructors: ");
        setInstructors(ins);
        while (true) {
            String s = Validator.getStringInput("Note: ");
            if (s.isEmpty()) {
                System.out.println("Data input is  invalid");
                continue;
            }
            setNote(s);
            break;
        }
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
