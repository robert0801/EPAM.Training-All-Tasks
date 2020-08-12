package Classes;

import java.util.Arrays;

public class Abiturient {
    private int id;
    private String family;
    private String name;
    private String surname;
    private String address;
    private int phone;
    private int[] gradeStudent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int[] getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(int[] gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public double ratingStudent(int[] gradeStudent){
        int sumGrade = 0;
        for (int i = 0; i < gradeStudent.length; i++){
            sumGrade += gradeStudent[i];
        }
        return sumGrade/(gradeStudent.length * 1.0);
    }

    @Override
    public String toString() {
        return "Abiturient: " +
                "id=" + id +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", gradeStudent=" + Arrays.toString(gradeStudent);
    }

    public Abiturient(int id, String family, String name, String surname, String address, int phone, int[] gradeStudent) {
        this.id = id;
        this.family = family;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.gradeStudent = gradeStudent;
    }

    public Abiturient(int id, String family, String name, String surname, int[] gradeStudent) {
        this.id = id;
        this.family = family;
        this.name = name;
        this.surname = surname;
        this.gradeStudent = gradeStudent;
    }
}
