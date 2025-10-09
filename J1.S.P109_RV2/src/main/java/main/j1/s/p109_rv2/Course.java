package main.j1.s.p109_rv2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Course {

    protected static final DateTimeFormatter DMY = DateTimeFormatter.ofPattern("d/M/yyyy");

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

    public void inputAll() {
        while (true) {
            String id = Validator.getStringInput("Course ID: ");
            if (id.isEmpty()) {
                System.out.println("Data input is  invalid");
                continue;
            }
            setCourseId(id);
            break;
        }

        while (true) {
            String name = Validator.getStringInput("Course name: ");
            if (name.isEmpty()) {
                System.out.println("Data input is  invalid");
                continue;
            }
            setCourseName(name);
            break;
        }

        while (true) {
            String s = Validator.getStringInput("Credits: ");
            try {
                int v = Integer.parseInt(s);
                if (v > 0) {
                    setCredits(v);
                    break;
                }
            } catch (NumberFormatException ignore) {
            }
            System.out.println("Data input is  invalid");
        }
    }

    public String basicInfo() {
        return String.format("%s-%s-%d", getCourseId(), getCourseName(), getCredits());
    }

    public void printDetail() {
        System.out.println("Course ID: " + getCourseId());
        System.out.println("Course name: " + getCourseName());
        System.out.println("Credits: " + getCredits());
    }

    public static String fmt(LocalDate d) {
        return d == null ? "" : d.format(DMY);
    }
}
