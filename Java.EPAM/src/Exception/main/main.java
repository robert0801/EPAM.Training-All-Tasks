package Exception.main;

import Exception.exception.*;
import java.util.ArrayList;
import java.util.HashMap;
import static Exception.main.Subject.*;



public class main {
    public static void main(String[] args) throws ExceptionClass {
        Student student1 = new Student(new HashMap<Subject, Integer>() {{
            put(BIOLOGY, 8);
            put(MATH, 4);
            put(ENGLISH, 10);
            put(PHYSIC, 6);
        }}, "Иванов Иван Иванович");

        Student student2 = new Student(new HashMap<Subject, Integer>() {{
            put(ASTRONOMY, 6);
            put(CHEMISTRY, 2);
        }}, "Петров Петр Петрович");

        Student student3 = new Student(new HashMap<Subject, Integer>() {{
            put(PHYSIC, 3);
            put(HISTORY, 5);
        }}, "Васильев Василий Васильевич");

        Student student4 = new Student(new HashMap<Subject, Integer>() {{
            put(ASTRONOMY, 4);
            put(MATH, 10);
        }},
                "Сергеев Сергей Сергеевич");
        Student student5 = new Student(new HashMap<Subject, Integer>() {{
            put(HISTORY, 9);
            put(MATH, 5);
        }}, "Чепелин Олег Олегович");

        Student student6 = new Student(new HashMap<Subject, Integer>() {{
            put(ENGLISH, 10);
            put(ASTRONOMY, 5);
            put(PHYSIC, 8);
        }}, "Китаров Дмитрий Дмитриевич");

        student4.averageMarkStudent();
        student6.averageMarkStudent();

        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();
        group1.addStudentInGroup("ТЭЭО", new ArrayList<>() {{
            add(student1);
            add(student2);
        }});
        group2.addStudentInGroup("ТЕОРЕТИЧЕСКАЯ ФИЗИКА", new ArrayList<>() {{
            add(student3);
            add(student4);
        }});
        group3.addStudentInGroup("ИИТ", new ArrayList<>() {{
            add(student5);
            add(student6);
        }});


        group1.printAverageMarkOnSubjectInGroup(MATH);
        group2.printAverageMarkOnSubjectInGroup(ASTRONOMY);
        group3.printAverageMarkOnSubjectInGroup(HISTORY);

        Faculty faculty1 = new Faculty();
        Faculty faculty2 = new Faculty();


        faculty1.addGroupIFaculty("Физтех", new ArrayList<Group>() {{
            add(group1);
            add(group2);
        }});
        faculty2.addGroupIFaculty("Биологии", new ArrayList<Group>() {{
            add(group3);

        }});

        faculty1.averageMarkOnSubjectOnFaculty(MATH);
        faculty2.averageMarkOnSubjectOnFaculty(HISTORY);

        University university = new University();
        university.addFacultyInUniversity(new ArrayList<Faculty>() {{
            add(faculty1);
            add(faculty2);
        }});

        university.averageMarkOnSubjectOnUniversity(PHYSIC);
    }
}





