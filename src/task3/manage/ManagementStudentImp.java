package task3.manage;

import task3.model.Student;
import task3.custom.ArrayList;
import task3.custom.List;
import task3.validate.Validate;
import task3.validate.ValidateImp;

import java.util.*;
public class ManagementStudentImp implements ManageStudent {
    private final Validate validate = new ValidateImp();

    @Override
    public void addStudent(List<Student> students) {
        if (students == null) {
            System.out.println("Something wrong!");
            return;
        }

        String id = validate.getString("Input student indentification: ", "Input not empty");
        while (validate.isIdExist(students, id)) {
            id = validate.getString("Input student indentification: ", "Input not empty");
        }
        String name = validate.getString("Input name: ", "Input not empty");
        Integer age = validate.getInt("Input age: ", "Input not empty", 0, 1000);
        double mathPoints = validate.getDouble("Input math points: ", "Please fill in math points!!", 0, 10);
        double physicPoints = validate.getDouble("Input physicPoints: ", "Please fill in math points!!!", 0, 10);
        double chemistryPoints = validate.getDouble("Input chemistryPoints: ", "Please fill in math points!!", 0, 10);
        Student student = new Student(id, name, age, mathPoints, physicPoints, chemistryPoints);
        students.add(student);
        System.out.println("success!!");
    }

    @Override
    public void displayAllStudent(List<Student> listStudent) {
        if (listStudent == null) {
            System.out.println("Something wrong!");
            return;
        }
        System.out.format("\t%15s", "ID");
        System.out.format("%15s", "NAME");
        System.out.format("%15s", "AGE");
        System.out.format("%15s", "MATH");
        System.out.format("%15s", "PHYSICAL");
        System.out.format("%15s", "CHEMISTRY");
        System.out.format("%15s", "AVERAGE");
        System.out.format("%15s", "ACADEMIC ABILITY");
        System.out.println("");
        for (Student student : listStudent) {
            student.display();
            System.out.println();
        }
    }

    @Override
    public Student findById(List<Student> students) {
        if (students == null) {
            System.out.println("List has no student");
        }

        String id = validate.getString("Input staff indentification: ", "Input not empty");
        for(Student student : students){
                if(student.getId().equalsIgnoreCase(id)){
                System.out.println("\tSINH VIEN CO MA SINH VIEN BANG " + id + " CO THONG TIN LA: ");
                System.out.format("\t%15s", "ID");
                System.out.format("%15s", "NAME");
                System.out.format("%15s", "AGE");
                System.out.format("%15s", "MATH");
                System.out.format("%15s", "PHYSICAL");
                System.out.format("%15s", "CHEMISTRY");
                System.out.format("%15s", "AVERAGE");
                System.out.format("%15s", "ACADEMIC ABILITY");
                System.out.println("");
                student.display();
                System.out.println("");
                return student;
                }
            }
        System.out.println("\tCould not find student had id " + id + "!");
        return null;
    }

    @Override
    public void updateById(List<Student> students) {
        Student student = findById(students);
        String name = validate.getString("Input name: ", "Input not empty");
        Integer age = validate.getInt("Input age: ", "Input not empty", 0, 1000);
        double mathPoints = validate.getDouble("Input math points: ", "Please fill in math points!!", 0, 10);
        double physicPoints = validate.getDouble("Input physicPoints: ", "Please fill in math points!!!", 0, 10);
        double chemistryPoints = validate.getDouble("Input chemistryPoints: ", "Please fill in math points!!", 0, 10);
        student.setName(name);
        student.setAge(age);
        student.setMathPoint(mathPoints);
        student.setPhysicPoint(physicPoints);
        student.setChemistryPoint(chemistryPoints);
        System.out.println("\tSuccess!!");
    }

    @Override
    public void deleteById(List<Student> students) {
        String id = validate.getString("Input student indentification: ", "Input not empty");
        if (!validate.isIdExist(students, id)) {
            System.out.println("Id not exist!");
            return;
        }

        Student studentDelete = null;
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                studentDelete = student;
                break;
            }
        }

        students.remove(studentDelete);
        System.out.println("Student has id " + id + "was deleted");
    }

    public void selectionSort(Double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            Double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public List<Student> sort(Student[] students, String choice) { //selection sort
        List<Student> res = new ArrayList<>();
        //sort by average points
        if (choice.equals("avg")) {
            for (int i = 0; i < students.length; i++) {
                Student key = students[i];
                int j = i - 1;
                while (j > 0 && students[j].avg() > key.avg()) {
                    students[j + 1] = students[j];
                    j = j - 1;
                }
                students[j + 1] = key;
            }
            for (Student student : students) {
                res.add(student);
            }
        }
        if (choice.equals("name")) {
            for (int i = 0; i < students.length; i++) {
                Student key = students[i];
                int j = i - 1;
                while (j > 0 && students[j].getName().compareTo(key.getName()) > 0) {
                    students[j + 1] = students[j];
                    j = j - 1;
                }
                students[j + 1] = key;
            }
            for (Student student : students) {
                res.add(student);
            }
        }
        if (choice.equals("id")) {
            for (int i = 0; i < students.length; i++) {
                Student key = students[i];
                int j = i - 1;
                while (j > 0 && students[j].getId().compareTo(key.getId())>0) {
                    students[j + 1] = students[j];
                    j = j - 1;
                }
                students[j + 1] = key;
            }
            for (Student student : students) {
                res.add(student);
            }
        }
        return res;
    }

    @Override
    public List<Student> sortById(List<Student> students, String choice) {
        int n = students.size();
        Student[] a = new Student[n];
        for(int i = 0; i < n; i++){
            a[i] = students.get(i);
        }
        return sort(a, choice);
    }

    @Override
    public List<Student> sortByName(List<Student> students, String choice) {
        int n = students.size();
        Student[] a = new Student[n];
        for(int i = 0; i < n; i++){
            a[i] = students.get(i);
        }
        return sort(a, choice);
    }

    @Override
    public List<Student> sortByAvgPoints(List<Student> students, String choice) {
        int n = students.size();
        Student[] a = new Student[n];
        for(int i = 0; i < n; i++){
            a[i] = students.get(i);
        }
        return sort(a, choice);
    }
}