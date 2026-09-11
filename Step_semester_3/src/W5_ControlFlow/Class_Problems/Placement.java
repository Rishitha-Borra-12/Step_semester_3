import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    double getCompositeScore() {

        return cgpa * 10 + codingScore;
    }

    public int compareTo(Candidate other) {

        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public String getName() {

        return name;
    }
}

public class Main {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa)) {

                shortlisted[count] = candidates[i];
                count++;

            } else if (Candidate.isEligible(
                    candidates[i].cgpa,
                    candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result + (i + 1) + ". "
                    + finalList[i].getName()
                    + " (" + finalList[i].getCompositeScore() + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            String name = sc.next();
            double cgpa = sc.nextDouble();
            int codingScore = sc.nextInt();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));
    }
}