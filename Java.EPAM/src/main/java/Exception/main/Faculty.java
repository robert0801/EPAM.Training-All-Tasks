package Exception.main;
import Exception.exception.*;
import java.util.ArrayList;

public class Faculty extends University {
    private String nameFaculty;
    private ArrayList<Group> facultyList = new ArrayList<Group>();

    public void addGroupIFaculty(String nameFaculty, ArrayList<Group> facultyList) throws ExceptionClass {
        if (facultyList.isEmpty()) throw new ExceptionClass("На факультете " + nameFaculty + " нет групп");
        this.facultyList = facultyList;
        this.nameFaculty = nameFaculty;
    }


    public String getNameFaculty() {
        return nameFaculty;
    }

    public ArrayList<Group> getFacultyList() {
        return facultyList;
    }


    public void averageMarkOnSubjectOnFaculty(Subject subject) throws ExceptionClass {
        int sumOnSubjectOnFaculty = 0;
        int countMarkOnFaculty = 0;
        for (int i = 0; i < facultyList.size(); i++) {
            Group checkedGroup = facultyList.get(i);
                for (int j = 0; j < checkedGroup.getStudentsInGroup().size(); j++) {
                    if (checkedGroup.getStudentsInGroup().get(j).getRating().containsKey(subject)) {
                        sumOnSubjectOnFaculty += checkedGroup.averageMarkOnSubjectInGroup(subject);
                        countMarkOnFaculty++;
                    }
                }
            }
        if (sumOnSubjectOnFaculty == 0) throw new ExceptionClass("На факультете " + getNameFaculty() + " нет учеников, изучающих " + subject);
        else    System.out.println("На факультете " + getNameFaculty() + " по предмету " + subject +
        " средний балл " + (double) sumOnSubjectOnFaculty / countMarkOnFaculty);
        }
    }

