package W2_ControlFlow.Class_Problems;

import java.util.Scanner;

public class StudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String roll = fields[1];
        String dept = fields[2];

        System.out.println("Name: " + name + " | Roll No: " + roll + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);
    }
}