package task3.validate;

import task3.custom.List;
import task3.model.Student;

public interface Validate {
    int getInt(String msg, String err, int min, int max);
    double getDouble(String msg, String err, double min, double max);
    String getString(String msg, String err);
    Boolean isIdExist(List<Student> students, String id);
}
