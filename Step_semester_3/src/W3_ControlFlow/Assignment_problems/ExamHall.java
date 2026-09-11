import java.util.Scanner;

class ExamHall {
    String hallName;
    int seatsFilled;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ExamHall hallA = new ExamHall();
        ExamHall hallB = new ExamHall();

        hallA.hallName = sc.nextLine();
        hallB.hallName = sc.nextLine();

        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;

        System.out.println(hallA.hallName + " seatsFilled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seatsFilled: " + hallB.seatsFilled);
    }
}