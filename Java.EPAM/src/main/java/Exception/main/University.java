package Exception.main;
import Exception.exception.*;

import java.util.ArrayList;

public class University{

    private ArrayList<Faculty> universityList = new ArrayList<Faculty>();

    public University(ArrayList<Faculty> universityList) throws ExceptionClass {
        if (universityList.isEmpty()) throw new ExceptionClass("The university without faculty.");
        this.universityList = universityList;
    }

    public void averageMarkOnSubjectOnUniversity(Subject subject) throws ExceptionClass {
        int sumOnSubjectOnUniversity = 0;
        int countMarkOnUniversity = 0;
        for (int i = 0; i < universityList.size(); i++){
            Faculty checkedFaculty = universityList.get(i);
            for (int j = 0; j < checkedFaculty.getFacultyList().size(); j++){
                Group checkedGroup = checkedFaculty.getFacultyList().get(j);
                for (int k = 0; k < checkedGroup.getStudentsInGroup().size(); k++) {
                    if (checkedGroup.getStudentsInGroup().get(k).getRating().containsKey(subject)) {
                        sumOnSubjectOnUniversity += checkedGroup.averageMarkOnSubjectInGroup(subject);
                        countMarkOnUniversity++;
                    }
                }
            }
        }
        if (sumOnSubjectOnUniversity == 0) throw new ExceptionClass("There are no students in the university" +
                " with learning " + subject);
        else    System.out.println("On the university in the subject " + subject +
                " middle mark " + (double) sumOnSubjectOnUniversity / countMarkOnUniversity);

    }
}
