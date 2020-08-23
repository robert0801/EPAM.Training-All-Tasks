package Exception.main;

import Exception.exception.*;

import java.util.HashMap;
import java.util.Map;

public class Student extends Group{
    private int sumMark = 0;
    private int quantityMark = 0;
    private HashMap<Subject, Integer> rating;
    private String name;


    public Student(HashMap<Subject, Integer> rating, String name) throws ExceptionClass {
        this.rating = rating;
        this.name = name;

        if (rating.size() == 0) {
            throw new ExceptionClass("У студента " + getName() + " отсутсвуют предметы");
        }

        for (Map.Entry<Subject, Integer> iteratorStudent : rating.entrySet()) {
            if (iteratorStudent.getValue() > 10 || iteratorStudent.getValue() < 0){
                throw new ExceptionClass("У студента " + name + " введена неверная оценка");
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
        System.out.println("Средний бал студента " + this.getName() + " = " + (double) this.getSumMark() / this.getQuantityMark());
    }

}
