package Classes;

import java.util.Comparator;

public class ComparatorAbiturient implements Comparator<Abiturient> {
        public int compare(Abiturient o1, Abiturient o2) {
            return (int) (o1.ratingStudent(o1.getGradeStudent()) - o2.ratingStudent(o2.getGradeStudent()));
        }
}


