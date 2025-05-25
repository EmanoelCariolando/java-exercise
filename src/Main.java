import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.entities.OrderStatus;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name,email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status (PENDING, PAID, SHIPPED, DELIVERED): ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order or = new Order(client,new Date(),status);


        System.out.print("How many items to this: ");
        int many = sc.nextInt();

        for(int i = 0; i < many; i++) {
            System.out.println("Enter item #" + (i + 1) + " data: ");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();


            Product product = new Product(productName,productPrice);

            System.out.print("Quantity: ");
            int quantityItem = sc.nextInt();

            OrderItem item = new OrderItem(quantityItem,new Product(productName,productPrice));
            or.addItem(item);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(or);

    }

    }