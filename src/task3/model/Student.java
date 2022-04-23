package task3.model;

public class Student{
    private String id;
    private String name;
    private Integer age;
    private double mathPoint;
    private double physicPoint;
    private double chemistryPoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getPhysicPoint() {
        return physicPoint;
    }

    public void setPhysicPoint(double physicPoint) {
        this.physicPoint = physicPoint;
    }

    public double getChemistryPoint() {
        return chemistryPoint;
    }

    public void setChemistryPoint(double chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public Student() {
    }

    public Student(String id, String name, Integer age, double mathPoint, double physicPoint, double chemistryPoint) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mathPoint = mathPoint;
        this.physicPoint = physicPoint;
        this.chemistryPoint = chemistryPoint;
    }

    public double avg() {
        return (this.mathPoint + this.physicPoint + this.chemistryPoint) / 3;
    }

    public String academicAbility() {
        double temp = this.avg();
        return temp < 5 ? "Week" : (temp < 7 ? "Average" : (temp < 8.5 ? "Good" : "Excellent"));
    }

    public void display() {
        System.out.format("\t%15s", this.id);
        System.out.format("%15s", this.name);
        System.out.format("%15d", this.age);
        System.out.format("%15f", this.mathPoint);
        System.out.format("%15f", this.chemistryPoint);
        System.out.format("%15f", this.physicPoint);
        System.out.format("%15f", this.avg());
        System.out.format("%15s", this.academicAbility());
    }
}
