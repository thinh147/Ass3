package task3.manage;

import task3.model.Student;
import task3.custom.List;

import java.util.Map;

public interface ManageStudent {

    void addStudent(List<Student> students);
    void displayAllStudent(List<Student> listStudent);
    Student findById(List<Student> students);
    void updateById(List<Student> students);
    void deleteById(List<Student> students);
    List<Student> sortById(List<Student> students, String choice);
    List<Student> sortByName(List<Student> students, String choice);
    List<Student> sortByAvgPoints(List<Student> students, String choice);
}
