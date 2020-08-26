package Exception.main;

import Exception.exception.*;
import java.util.ArrayList;
import java.util.HashMap;
import static Exception.main.Subject.*;

public class Main {
    public static void main(String[] args) throws ExceptionClass {
        Student student1 = new Student(new HashMap<Subject, Integer>() {{
            put(BIOLOGY, 8);
            put(MATH, 4);
            put(ENGLISH, 10);
            put(PHYSIC, 6);
        }}, "Ivanov Ivan Ivanovich");

        Student student2 = new Student(new HashMap<Subject, Integer>() {{
            put(ASTRONOMY, 6);
            put(CHEMISTRY, 2);
        }}, "Petrov Petr Petrovovich");

        Student student3 = new Student(new HashMap<Subject, Integer>() {{
            put(PHYSIC, 3);
            put(HISTORY, 5);
        }}, "Vasiliev Vasiliy Vasilievich");

        Student student4 = new Student(new HashMap<Subject, Integer>() {{
            put(ASTRONOMY, 4);
            put(MATH, 10);
        }}, "Sergeev Sergei Sergeevich");
        Student student5 = new Student(new HashMap<Subject, Integer>() {{
            put(HISTORY, 9);
            put(MATH, 5);
        }}, "Chepelin Oleg Olegovich");

        Student student6 = new Student(new HashMap<Subject, Integer>() {{
            put(ENGLISH, 10);
            put(ASTRONOMY, 5);
            put(PHYSIC, 8);
        }}, "Kitarov Dmitriy Dmitrievich");

        student1.averageMarkStudent();
        student2.averageMarkStudent();
        student3.averageMarkStudent();
        student4.averageMarkStudent();
        student5.averageMarkStudent();
        student6.averageMarkStudent();

        Group group1 = new Group("TEEO", new ArrayList<>() {{
            add(student1);
            add(student2);
        }});
        Group group2 = new Group("THEORETICAL PHYSICS", new ArrayList<>() {{
            add(student3);
            add(student4);
        }});
        Group group3 = new Group("IIT", new ArrayList<>() {{
            add(student5);
            add(student6);
        }});

        group1.printAverageMarkOnSubjectInGroup(MATH);
        group2.printAverageMarkOnSubjectInGroup(ASTRONOMY);
        group3.printAverageMarkOnSubjectInGroup(HISTORY);

        Faculty faculty1 = new Faculty("PHYSICS FACULTY", new ArrayList<Group>() {{
            add(group1);
            add(group2);
        }});
        Faculty faculty2 = new Faculty("BIOLOGY FACULTY", new ArrayList<Group>() {{
            add(group3);
        }});

        faculty1.averageMarkOnSubjectOnFaculty(MATH);
        faculty2.averageMarkOnSubjectOnFaculty(HISTORY);

        University university = new University(new ArrayList<Faculty>() {{
            add(faculty1);
            add(faculty2);
        }});

        university.averageMarkOnSubjectOnUniversity(PHYSIC);
    }
}





