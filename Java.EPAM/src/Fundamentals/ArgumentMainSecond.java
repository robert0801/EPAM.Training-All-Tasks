package Fundamentals;

public class ArgumentMainSecond {
    public static void main(String[] args) {
        int sum = 0;
        int comp = 1;
        for (String i : args){
            sum += Integer.parseInt(i);
            comp *= Integer.parseInt(i);
        }
        System.out.println("Сумма аргументов командной строки " + sum);
        System.out.println("Произведение аргументов командной строки " + comp);
    }
}
