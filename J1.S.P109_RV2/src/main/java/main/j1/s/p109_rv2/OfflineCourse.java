package main.j1.s.p109_rv2;

import java.time.LocalDate;

public class OfflineCourse extends Course {
    private LocalDate begin;
    private LocalDate end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }

    public LocalDate getBegin() { return begin; }
    public void setBegin(LocalDate begin) { this.begin = begin; }

    public LocalDate getEnd() { return end; }
    public void setEnd(LocalDate end) { this.end = end; }

    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus == null ? "" : campus.trim(); }

    @Override
    public void printDetail() {
        super.printDetail();
        System.out.println("Begin: " + (begin == null ? "" : CourseManagement.fmt(begin)));
        System.out.println("End: " + (end == null ? "" : CourseManagement.fmt(end)));
        System.out.println("Campus: " + getCampus());
    }

    public String offlineInfo() {
        return String.format("%s-%s-%d-%s-%s-%s",
                getCourseId(), getCourseName(), getCredits(),
                (begin == null ? "" : CourseManagement.fmt(begin)),
                (end == null ? "" : CourseManagement.fmt(end)),
                getCampus());
    }
}
