import java.util.Scanner;

class Product {
    String productId;
    String productName;

    Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productId = sc.nextLine();
        String productName = sc.nextLine();

        Product p = new Product(productId, productName);

        System.out.println(p.productId + " - " + p.productName);
    }
}