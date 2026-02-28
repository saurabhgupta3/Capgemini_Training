import java.util.*;

class User {
    String name;
    String email;
    String pass;
    String role;

    User(String name, String email, String pass, String role) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }
}

class Order {
    int id;
    String rec;
    String sender;
    String recAdd;
    String senderAdd;
    int price;
    String courierName = "vishal";
    String courierCompany = "neo-CNS";

    Order(int id, String rec, String sender, String recAdd, String senderAdd, int price) {
        this.id = id;
        this.rec = rec;
        this.sender = sender;
        this.recAdd = recAdd;
        this.senderAdd = senderAdd;
        this.price = price;
    }
}

public class Logistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        users.add(new User("Admin", "admin@neocns.com", "admin123", "admin"));
        while (true) {
            System.out.print("enter 1 for login and 2 for register and -1 for exit : ");
            int ch = Integer.parseInt(sc.nextLine());
            if (ch == 2) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.println("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String pass = sc.nextLine();
                System.out.print("Enter role: ");
                String role = sc.nextLine();
                if (role.equals("admin")) {
                    System.out.println("Admin role not allowed");
                    break;
                }
                users.add(new User(name, email, pass, role));
            }
            System.out.println("Enter 1 to create Order and 2 to track order: ");
            int opt = Integer.parseInt(sc.nextLine());
            if (opt == 1) {
                int id;
                String rec;
                String sender;
                String recAdd;
                String senderAdd;
                int price;
                System.out.println("Enter order id: ");
                id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter receiver name: ");
                rec = sc.nextLine();
                System.out.println("Enter sender name: ");
                sender = sc.nextLine();
                System.out.println("Enter receiver address: ");
                recAdd = sc.nextLine();
                System.out.println("Enter sender address: ");
                senderAdd = sc.nextLine();
                System.out.println("Enter the Price: ");
                price = Integer.parseInt(sc.nextLine());
            }
        }
    }
}