package main.j1.s.p109_rv2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? "" : campus.trim();
    }

    @Override
    public void inputAll() {
        super.inputAll();
        while (true) {
            try {
                this.begin = LocalDate.parse(Validator.getStringInput("Begin: "), DMY);
                this.end = LocalDate.parse(Validator.getStringInput("End: "), DMY);
                if (this.end.isAfter(this.begin)) {
                    break;
                }
                System.out.println("Data input is  invalid, end must be after begin");
            } catch (DateTimeParseException e) {
                System.out.println("Data input is  invalid");
            }
        }
        while (true) {
            String c = Validator.getStringInput("Campus: ");
            if (c.isEmpty()) {
                System.out.println("Data input is  invalid");
                continue;
            }
            setCampus(c);
            break;
        }
    }

    @Override
    public void printDetail() {
        super.printDetail();
        System.out.println("Begin: " + (begin == null ? "" : fmt(begin)));
        System.out.println("End: " + (end == null ? "" : fmt(end)));
        System.out.println("Campus: " + getCampus());
    }

    public String offlineInfo() {
        return String.format("%s-%s-%d-%s-%s-%s",
                getCourseId(), getCourseName(), getCredits(),
                (begin == null ? "" : fmt(begin)),
                (end == null ? "" : fmt(end)),
                getCampus());
    }
}
