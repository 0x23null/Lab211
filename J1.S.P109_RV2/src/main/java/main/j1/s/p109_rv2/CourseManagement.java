package main.j1.s.p109_rv2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private final List<Course> courses = new ArrayList<>();
    private static final DateTimeFormatter DMY = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static String fmt(LocalDate d) {
        return d == null ? "" : d.format(DMY);
    }

    public int display() {
        System.out.println("*** Course Management *** ");
        System.out.println("1. Add online course/ offline course");
        System.out.println("2. Update course");
        System.out.println("3. Delete course");
        System.out.println("4. Print all / online course / offline course");
        System.out.println("5. Search information base on course name");
        System.out.println("6. Exit");
        System.out.print("You choose: ");
        return Validator.getIntInput();
    }

    public void run() {
        while (true) {
            int c = display();
            switch (c) {
                case 1 -> addCourse();
                case 2 -> updateCourse();
                case 3 -> deleteCourse();
                case 4 -> printCourse();
                case 5 -> searchCourse();
                case 6 -> { System.out.println("BYE AND SEE YOU NEXT TIME"); return; }
                default -> System.out.println("Data input is  invalid");
            }
        }
    }

    private boolean idExists(String id) {
        return courses.stream().anyMatch(cs -> cs.getCourseId().equalsIgnoreCase(id));
    }

    private Course findById(String id) {
        return courses.stream()
                .filter(cs -> cs.getCourseId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    private boolean nameExists(String name) {
        return courses.stream().anyMatch(cs -> cs.getCourseName().equalsIgnoreCase(name));
    }

    private int askCredits() {
        while (true) {
            String s = Validator.getStringInput("Credits: ");
            try {
                int v = Integer.parseInt(s);
                if (v > 0) return v;
            } catch (NumberFormatException ignore) { }
            System.out.println("Data input is  invalid");
        }
    }

    private LocalDate askDate(String label) {
        while (true) {
            String s = Validator.getStringInput(label);
            try {
                LocalDate d = LocalDate.parse(s, DMY);
                if (d.isAfter(LocalDate.now())) return d;
                System.out.println("Data input is  invalid");
            } catch (DateTimeParseException e) {
                System.out.println("Data input is  invalid");
            }
        }
    }

    private void addCourse() {
        System.out.println("*** Add new course *** ");
        while (true) {
            String t = Validator.getStringInput("Online (O) or Offline (F): ");
            if ("O".equals(t)) {
                createOnline();
                return;
            } else if ("F".equals(t)) {
                createOffline();
                return;
            } else {
                System.out.println("Data input is  invalid");
            }
        }
    }

    private void createOnline() {
        System.out.println("Create new online course");
        OnlineCourse oc = new OnlineCourse();
        while (true) {
            String id = Validator.getStringInput("Course ID: ");
            
            if (id.isEmpty()) {
                System.out.println("Can't empty please enter again.");
                continue;
            }
            
            if (idExists(id)) {
                System.out.println("Data input is invalid, ID must be unique");
                continue;
            }
            oc.setCourseId(id);
            break;
        }
        while (true) {
            String name = Validator.getStringInput("Course name: ");

            if (name.isEmpty()) {
                System.out.println("Can't empty please enter again.");
                continue;
            }
            
            if (nameExists(name)) {
                System.out.println("Data input is invalid");
                continue;
            }
            oc.setCourseName(name);
            break;
        }
        oc.setCredits(askCredits());
        while (true) {
            String p = Validator.getStringInput("Platform: ");
            if (p.isEmpty()) { System.out.println("Data input is  invalid"); continue; }
            oc.setPlatform(p); break;
        }
        String ins = Validator.getStringInput("Instructors: ");
        oc.setInstructors(ins);
        while (true) {
            String note = Validator.getStringInput("Note: ");
            if (note.isEmpty()) { System.out.println("Data input is  invalid"); continue; }
            oc.setNote(note); break;
        }
        courses.add(oc);
    }

    private void createOffline() {
        System.out.println("Create new offline course");
        OfflineCourse of = new OfflineCourse();
        while (true) {
            String id = Validator.getStringInput("Course ID: ");
            if (id.isEmpty()) {
                System.out.println("Data input is  invalid");
                continue;
            }
            if (idExists(id)) {
                System.out.println("Data input is  invalid, ID must be unique");
                continue;
            }
            of.setCourseId(id);
            break;
        }
        while (true) {
            String name = Validator.getStringInput("Course name: ");
            if (name.isEmpty()) { System.out.println("Data input is  invalid"); continue; }
            if (nameExists(name)) { System.out.println("Data input is  invalid"); continue; }
            of.setCourseName(name); break;
        }
        of.setCredits(askCredits());
        LocalDate begin;
        LocalDate end;
        while (true) {
            begin = askDate("Begin: ");
            end = askDate("End: ");
            if (end.isAfter(begin)) break;
            System.out.println("Data input is  invalid, end must be after begin");
        }
        of.setBegin(begin);
        of.setEnd(end);
        while (true) {
            String campus = Validator.getStringInput("Campus: ");
            if (campus.isEmpty()) { System.out.println("Data input is  invalid"); continue; }
            of.setCampus(campus); break;
        }
        courses.add(of);
    }

    private void updateCourse() {
        System.out.println("*** Update course *** ");
        Course c = findWithRetry();
        if (c == null) return;

        System.out.println("*** Search results *** ");
        c.printDetail();
        System.out.println("*** Updating *** ");
        System.out.println("Note: Enter empty if you don't want to change it.");

        String id = Validator.getStringInput("Course ID: ");
        if (!id.isEmpty()) {
            if (!idExists(id) || c.getCourseId().equalsIgnoreCase(id)) {
                c.setCourseId(id);
            } else {
                System.out.println("Data input is  invalid, ID must be unique");
            }
        }

        String name = Validator.getStringInput("Course name: ");
        if (!name.isEmpty()) {
            if (!nameExists(name) || c.getCourseName().equalsIgnoreCase(name)) {
                c.setCourseName(name);
            } else {
                System.out.println("Data input is  invalid");
            }
        }

        String cr = Validator.getStringInput("Credits: ");
        if (!cr.isEmpty()) {
            try {
                int v = Integer.parseInt(cr);
                if (v > 0) c.setCredits(v);
                else System.out.println("Data input is  invalid");
            } catch (NumberFormatException e) {
                System.out.println("Data input is  invalid");
            }
        }

        if (c instanceof OnlineCourse oc) {
            String p = Validator.getStringInput("Platform: ");
            if (!p.isEmpty()) oc.setPlatform(p);
            String ins = Validator.getStringInput("Instructors: ");
            if (!ins.isEmpty()) oc.setInstructors(ins);
            String note = Validator.getStringInput("Note: ");
            if (!note.isEmpty()) oc.setNote(note);
        } else if (c instanceof OfflineCourse of) {
            String b = Validator.getStringInput("Begin: ");
            if (!b.isEmpty()) {
                try {
                    LocalDate nb = LocalDate.parse(b, DMY);
                    if (nb.isAfter(LocalDate.now())) of.setBegin(nb); else System.out.println("Data input is  invalid");
                } catch (Exception e) { System.out.println("Data input is  invalid"); }
            }
            String e = Validator.getStringInput("End: ");
            if (!e.isEmpty()) {
                try {
                    LocalDate ne = LocalDate.parse(e, DMY);
                    if (ne.isAfter(LocalDate.now())) of.setEnd(ne); else System.out.println("Data input is  invalid");
                } catch (Exception ex) { System.out.println("Data input is  invalid"); }
            }
            if (of.getBegin()!=null && of.getEnd()!=null && !of.getEnd().isAfter(of.getBegin())) {
                System.out.println("Data input is  invalid, end must be after begin");
            }
            String campus = Validator.getStringInput("Campus: ");
            if (!campus.isEmpty()) of.setCampus(campus);
        }
        System.out.println("Updated successfully");
    }

    private Course findWithRetry() {
        while (true) {
            String id = Validator.getStringInput("Course ID: ");
            Course c = findById(id);
            if (c != null) return c;
            String again = Validator.getStringInput("No data found, do you want to find again? (Y/N): ");
            if (!"Y".equalsIgnoreCase(again)) return null;
        }
    }

    private void deleteCourse() {
        System.out.println("*** Delete course *** ");
        Course c = findWithRetry();
        if (c == null) return;
        courses.remove(c);
    }

    private void printCourse() {
        System.out.println("*** Print course *** ");
        while (true) {
            String mode = Validator.getStringInput("Do you want to print all (A), online course (O) or offline course (F): ");
            switch (mode) {
                case "A" -> {
                    System.out.println("Course ID-Course name-Credits");
                    for (Course c : courses) System.out.println(c.basicInfo());
                    return;
                }
                case "O" -> {
                    System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note");
                    for (Course c : courses) if (c instanceof OnlineCourse oc) System.out.println(oc.onlineInfo());
                    return;
                }
                case "F" -> {
                    System.out.println("Course ID-Course name-Credits-Begin-End-Campus");
                    for (Course c : courses) if (c instanceof OfflineCourse of) System.out.println(of.offlineInfo());
                    return;
                }
                default -> System.out.println("Data input is  invalid");
            }
        }
    }

    private void searchCourse() {
        System.out.println("*** Searching *** ");
        Course c = findWithRetry();
        if (c == null) return;
        System.out.println("*** Search results *** ");
        c.printDetail();
    }
}
