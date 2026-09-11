package W2_ControlFlow.Class_Problems;

import java.util.Scanner;

public class BankReferenceValidator {

    static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() >= 3) {
            String bank = reference.substring(0, 3).toUpperCase();
            String rest = reference.substring(3);
            return bank + rest;
        }

        return reference;
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String date = reference.substring(3, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(bankCode);
        sb.append("] DATE: ");
        sb.append(date.substring(0, 2));
        sb.append("/");
        sb.append(date.substring(2, 4));
        sb.append("/");
        sb.append(date.substring(4, 6));
        sb.append(" | SEQ: ");
        sb.append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));
    }
}