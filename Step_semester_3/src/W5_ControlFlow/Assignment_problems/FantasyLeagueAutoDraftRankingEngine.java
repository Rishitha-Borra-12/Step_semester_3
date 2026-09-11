import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    public int compareTo(Player other) {

        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public String getName() {

        return name;
    }
}

public class Main {

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (Player.isDraftable(players[i].matchesPlayed)) {

                draftable[count] = players[i];
                count++;

            } else if (Player.isDraftable(
                    players[i].matchesPlayed,
                    players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result + (i + 1) + ". "
                    + finalList[i].getName();

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            String name = sc.next();
            int matchesPlayed = sc.nextInt();
            double battingAverage = sc.nextDouble();
            boolean injured = sc.nextBoolean();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }

        System.out.println(draftAndRank(players));
    }
}