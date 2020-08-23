package Exception.main;
import Exception.exception.*;
import java.util.ArrayList;
import java.util.Map;

public class Group extends Faculty{
    private String nameGroup;
    private ArrayList<Student> studentsInGroup;
    private int sumOnSubjectInGroup = 0;
    private int countMarkInGroup = 0;
    private Subject subject;


    public void addStudentInGroup(String nameGroup, ArrayList<Student> studentsInGroup) throws ExceptionClass {
        if (studentsInGroup.isEmpty()) throw new ExceptionClass("В группе " + nameGroup + " нет студентов");
        this.nameGroup = nameGroup;
        this.studentsInGroup = studentsInGroup;
    }

    public double averageMarkOnSubjectInGroup(Subject subject) throws ExceptionClass {
        if (studentsInGroup.isEmpty()) throw new ExceptionClass("В группе " + getNameGroup() + " нет студетов");
        for (Student student : studentsInGroup){
            for (Map.Entry<Subject, Integer> studentIterator : student.getRating().entrySet()){
                if (studentIterator.getKey().equals(subject)){
                    this.sumOnSubjectInGroup += studentIterator.getValue();
                    this.countMarkInGroup++;
                }

            }
        }
        return (double)sumOnSubjectInGroup / countMarkInGroup;
    }

    public void printAverageMarkOnSubjectInGroup(Subject subject) throws ExceptionClass {
        this.averageMarkOnSubjectInGroup(subject);
        if (sumOnSubjectInGroup == 0) throw new ExceptionClass("В группе " + getNameGroup() + " нет учеников, изучающих " + subject);
        else System.out.println("В группе " + getNameGroup() + " по предмету " + subject +
                " средний балл " + (double) sumOnSubjectInGroup / countMarkInGroup);
    }

    public String getNameGroup() {
        return nameGroup;
    }


    public ArrayList<Student> getStudentsInGroup() {
        return studentsInGroup;
    }

}

