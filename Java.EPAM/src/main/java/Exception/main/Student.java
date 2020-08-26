package Exception.main;

import Exception.exception.*;

import java.util.HashMap;
import java.util.Map;

public class Student{
    private int sumMark = 0;
    private int quantityMark = 0;
    private HashMap<Subject, Integer> rating;
    private String name;


    public Student(HashMap<Subject, Integer> rating, String name) throws ExceptionClass {
        this.rating = rating;
        this.name = name;

        if (rating.isEmpty()) {
            throw new ExceptionClass("The student " + getName() + " doesn't have any subject.");
        }

        for (Map.Entry<Subject, Integer> iteratorStudent : rating.entrySet()) {
            if (iteratorStudent.getValue() > 10 || iteratorStudent.getValue() < 0){
                throw new ExceptionClass("The student " + name + " has a incorrect mark in " + iteratorStudent.getKey() + ".");
            }
            this.sumMark += iteratorStudent.getValue();
            this.quantityMark++;
        }
    }

    public String getName() {
        return name;
    }

    public int getSumMark() {
        return sumMark;
    }

    public int getQuantityMark() {
        return quantityMark;
    }

    public HashMap<Subject, Integer> getRating() {
        return rating;
    }

    public void averageMarkStudent(){
        System.out.println("The middle mark " + this.getName() + " = " + (double) this.getSumMark() / this.getQuantityMark() + ".");
    }

}
