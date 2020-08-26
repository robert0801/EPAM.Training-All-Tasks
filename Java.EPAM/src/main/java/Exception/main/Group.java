package Exception.main;
import Exception.exception.*;
import java.util.ArrayList;
import java.util.Map;

public class Group {
    private String nameGroup;
    private ArrayList<Student> studentsInGroup;
    private int sumOnSubjectInGroup = 0;
    private int countMarkInGroup = 0;

    public Group (String nameGroup, ArrayList<Student> studentsInGroup) throws ExceptionClass {
        if (studentsInGroup.isEmpty()) throw new ExceptionClass(nameGroup + " without students.");
        else {
            this.nameGroup = nameGroup;
            this.studentsInGroup = studentsInGroup;
        }
    }

    public void printAverageMarkOnSubjectInGroup(Subject subject) throws ExceptionClass {
        double averageMark = averageMarkOnSubjectInGroup(subject);
        if (this.sumOnSubjectInGroup == 0) throw new ExceptionClass("There are no students in the group " + getNameGroup() +
                " which learning " + subject + ".");
        else System.out.println("In the group " + getNameGroup() + " in the subject " + subject +
                " average mark " + averageMark + ".");
    }

    public double averageMarkOnSubjectInGroup(Subject subject) {
        for (Student student : studentsInGroup){
            for (Map.Entry<Subject, Integer> studentIterator : student.getRating().entrySet()){
                if (studentIterator.getKey().equals(subject)){
                    this.sumOnSubjectInGroup += studentIterator.getValue();
                    this.countMarkInGroup++;
                }
            }
        }
        return (double) this.sumOnSubjectInGroup / this.countMarkInGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public ArrayList<Student> getStudentsInGroup() {
        return studentsInGroup;
    }

}

