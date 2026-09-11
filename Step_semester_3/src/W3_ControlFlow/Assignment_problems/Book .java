import java.util.Scanner;

class Book {
    String title;
    double price;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book b = new Book();

        b.title = sc.nextLine();
        b.price = sc.nextDouble();

        System.out.println("Title: " + b.title + " | Price: Rs " + b.price);
    }
}