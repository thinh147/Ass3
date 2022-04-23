package task3.validate;

import task3.custom.List;
import task3.model.Student;
import java.util.Scanner;

public class ValidateImp implements Validate{
    private Scanner sc = new Scanner(System.in);

    public int getInt(String msg, String err, int min, int max) {
        int a = 0;
        boolean check;
        do {
            check = true;
            try {
                System.out.print(msg);
                a = Integer.parseInt(sc.nextLine());
                if (a < min || a > max) {
                    System.out.println("Out of range, input again!");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(err);
                check = false;
            }
        } while (check == false);
        return a;
    }

    public double getDouble(String msg, String err, double min, double max) {
        double a = 0;
        boolean check;
        do {
            check = true;
            try {
                System.out.print(msg);
                a = Double.parseDouble(sc.nextLine());
                String value = Double.toString(a);
                if (a < min || a > max) {
                    System.out.println("Out of range, input again!");
                    check = false;

                }

            } catch (Exception e) {
                System.out.println(err);
                check = false;
            }
        } while (check == false);
        return a;
    }

    public String getString(String msg, String err) {
        String string;
        do {
            System.out.println(msg);
            string = sc.nextLine().trim();
            if (string.equals("")) {
                System.out.println(err);
            }
        } while (string.equals(""));
        return string;
    }

    public Boolean isIdExist(List<Student> students, String id) {

        for(Student student: students) {
            if(student.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

}
