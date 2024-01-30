package git_study;

public class User {
    private int grade;
    private int classNumber;
    private int number;
    private String name;

    public User(int grade, int classNumber, int number, String name) {
        this.grade = grade;
        this.classNumber = classNumber;
        this.number = number;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    };

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNumber() {
        return classNumber;
    };

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getNumber() {
        return number;
    };

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return grade + String.format("%02d", classNumber) + String.format("%02d", number);
    }
}
