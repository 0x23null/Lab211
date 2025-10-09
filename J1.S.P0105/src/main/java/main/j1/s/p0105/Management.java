package main.j1.s.p0105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Management {
    private List<Teacher> teacherList;
    private List<Student> studentList;
    
    private List<Person> personList; 

    public Management() {
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();
        personList = new ArrayList<>();
    }


    public void inputTeachers() {
        System.out.print("Enter number of teachers (n): ");
        int n = Validator.getIntInput();
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Input Teacher #" + (i + 1) + " ---");
            Teacher t = new Teacher();
            t.InputAll();
            
            teacherList.add(t);
            personList.add(t);
        }
    }

    public void printTeachers() {
        if (teacherList.isEmpty()) {
            System.out.println("No teachers entered yet.");
            return;
        }
        
        Collections.sort(teacherList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return t2.getYearInTheProfession() - t1.getYearInTheProfession(); 
            }
        });
        
        System.out.println("\n*** List of Teachers (Sorted by Experience Descending) ***");
    }

    public void inputStudents() {
        System.out.print("Enter number of students (n): ");
        int n = Validator.getIntInput();
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Input Student #" + (i + 1) + " ---");
            Student s = new Student();
            s.InputAll();
            
            studentList.add(s);
            personList.add(s); 
        }
    }
    
    // Chức năng 4: In danh sách sinh viên (Sắp xếp theo năm nhập học tăng dần)
    public void printStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students entered yet.");
            return;
        }
        
        // 1. Sắp xếp sinh viên theo Year of admission TĂNG DẦN [cite: 55]
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // Giả định bạn đã tạo getter getYearOfAdmission() trong lớp Student
                return s1.getYearOfAdmission() - s2.getYearOfAdmission(); 
            }
        });
        
        System.out.println("\n*** List of Students (Sorted by Admission Year Ascending) ***");
        // ... (Code in danh sách ra màn hình, như trong ví dụ đề bài [cite: 133, 134, 135])
    }

    // Chức năng 5: Tìm kiếm người theo tên (Sắp xếp kết quả theo năm sinh giảm dần)
    public void searchPersonByName() {
        System.out.print("Name: ");
        String searchName = Validator.getStringInput();
        
        List<Person> foundPeople = new ArrayList<>();
        
        // Duyệt qua danh sách chung để tìm người khớp tên
        for (Person p : personList) {
            // Kiểm tra xem tên tìm kiếm có chứa trong full name không (ví dụ: "Thanh Truc" tìm được "Tran Thanh Truc") [cite: 164]
            if (p.getFullName().toLowerCase().contains(searchName.toLowerCase())) {
                foundPeople.add(p);
            }
        }
        
        if (foundPeople.isEmpty()) {
            System.out.println("Result: not found");
            return;
        }

        // 2. Sắp xếp kết quả tìm kiếm theo Year of birth GIẢM DẦN [cite: 56]
        Collections.sort(foundPeople, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // Giảm dần: p2 - p1
                return p2.getYearOfBirth() - p1.getYearOfBirth(); 
            }
        });
        
        System.out.println("Result:");
        // ... (Code in danh sách ra màn hình [cite: 179, 181])
    }
    
    // Chức năng 6: In tất cả mọi người (Phục vụ Menu Person) [cite: 185]
    public void printAllPeople() {
         if (personList.isEmpty()) {
            System.out.println("No person entered yet.");
            return;
        }
        
        // In danh sách (Không yêu cầu sắp xếp cụ thể, in theo thứ tự nhập)
        System.out.println("\n*** All People List ***");
        // ... (Code in danh sách ra màn hình [cite: 191, 192, 193, 194, 195, 198])
    }

    // ... (Các phương thức khác)
}
