package task3;

import task3.custom.ArrayList;
import task3.custom.List;
import task3.manage.ManageStudent;
import task3.manage.ManagementStudentImp;
import task3.model.Student;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ManageStudent manage = new ManagementStudentImp();
        List<Student> list = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Feature 1-> 8, 0 to exit");
            System.out.println("0. Exit.");
            System.out.println("1. Insert Student.");
            System.out.println("2. Display. ");
            System.out.println("3. Find By Student Id. ");
            System.out.println("4. Update By Student Id. ");
            System.out.println("5. Delete By Student Id. ");
            System.out.println("6. Sort By Id. ");
            System.out.println("7. Sort By name. ");
            System.out.println("8. Sort By Avg Points. ");
            System.out.println();

            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("1. Insert Student. ");
                    manage.addStudent(list);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("2. List Student. ");
                    manage.displayAllStudent(list);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("3. Find By Student Id. ");
                    manage.findById(list);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("4. Update By Id. ");
                    manage.updateById(list);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("5. Delete By Id. ");
                    manage.deleteById(list);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("6. Sort By Id. ");
                    System.out.format("\t%15s", "ID");
                    System.out.format("%15s", "NAME");
                    System.out.format("%15s", "AGE");
                    System.out.format("%15s", "MATH");
                    System.out.format("%15s", "PHYSICAL");
                    System.out.format("%15s", "CHEMISTRY");
                    System.out.format("%15s", "AVERAGE");
                    System.out.format("%15s", "ACADEMIC ABILITY");
                    System.out.println();
                    for (Student student: manage.sortById(list, "id")) {
                        student.display();
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println("7. Sort By Name. ");
                    System.out.format("\t%15s", "ID");
                    System.out.format("%15s", "NAME");
                    System.out.format("%15s", "AGE");
                    System.out.format("%15s", "MATH");
                    System.out.format("%15s", "PHYSICAL");
                    System.out.format("%15s", "CHEMISTRY");
                    System.out.format("%15s", "AVERAGE");
                    System.out.format("%15s", "ACADEMIC ABILITY");
                    System.out.println();
                    for (Student student: manage.sortByName(list, "name")) {
                        student.display();
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("8. Sort by avg");
                    System.out.format("\t%15s", "ID");
                    System.out.format("%15s", "NAME");
                    System.out.format("%15s", "AGE");
                    System.out.format("%15s", "MATH");
                    System.out.format("%15s", "PHYSICAL");
                    System.out.format("%15s", "CHEMISTRY");
                    System.out.format("%15s", "AVERAGE");
                    System.out.format("%15s", "ACADEMIC ABILITY");
                    System.out.println();
                    for (Student student: manage.sortByAvgPoints(list, "avg")) {
                        student.display();
                        System.out.println();
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("INPUT AGAIN!!");
                    break;
            }
        }
    }

}
