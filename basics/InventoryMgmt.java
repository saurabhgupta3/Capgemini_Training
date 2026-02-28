import java.util.*;

class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class InventoryMgmt {

    static void addToCart(
            int choice,
            int amt,
            HashMap<Integer, Product> products,
            HashMap<Integer, Integer> stocks,
            HashMap<Integer, Integer> cart) {
        int id = choice - 1;
        int available = stocks.get(id);

        if (available >= amt) {
            cart.put(id, amt);
            System.out.println("added in cart");
        } else {
            System.out.println("not in stock that much amount");
        }
    }

    static void doBilling(
            HashMap<Integer, Product> products,
            HashMap<Integer, Integer> stocks,
            HashMap<Integer, Integer> cart,
            String currUser) {
        int price = 0;

        for (Map.Entry<Integer, Integer> it : cart.entrySet()) {
            int id = it.getKey();
            int amt = it.getValue();
            price += products.get(id).price * amt;
            stocks.put(id, stocks.get(id) - amt);
        }

        System.out.println("-----BILLING DETAILS------");
        System.out.println();
        System.out.println("Name: " + currUser);
        System.out.println();
        System.out.println("--Your product details--");
        System.out.println("Item     Amount");

        for (Map.Entry<Integer, Integer> it : cart.entrySet()) {
            int id = it.getKey();
            int amt = it.getValue();
            System.out.println(products.get(id).name + "      " + amt);
        }

        System.out.println("Total Price: " + price + " Rs");
        System.out.println("After including GST: " + (price + price * 0.18) + " Rs");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Product> products = new HashMap<>();
        products.put(0, new Product("soap", 30));
        products.put(1, new Product("biscuits", 20));
        products.put(2, new Product("chips", 15));

        HashMap<Integer, Integer> stocks = new HashMap<>();
        stocks.put(0, 10);
        stocks.put(1, 20);
        stocks.put(2, 30);

        HashMap<Integer, Integer> cart = new HashMap<>();

        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("saurabh", "abc123");
        userInfo.put("aman", "pass");
        userInfo.put("rahul", "word");

        System.out.println("------LOGIN--------");
        System.out.print("enter username: ");
        String currUser = sc.next();
        System.out.print("enter password: ");
        String currPass = sc.next();

        boolean isLoggedIn = false;

        if (userInfo.containsKey(currUser) && userInfo.get(currUser).equals(currPass)) {
            isLoggedIn = true;
        }

        if (!isLoggedIn) {
            System.out.println("wrong login details");
            return;
        }

        while (true) {
            System.out.println(
                    "enter your choice : (1 soap, 2 biscuits, 3 chips, 4 exit, 5 billing)");
            int choice = sc.nextInt();

            if (choice == 4)
                break;

            if (choice == 5) {
                doBilling(products, stocks, cart, currUser);
                break;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("wrong choice");
                continue;
            }

            System.out.print("enter amount: ");
            int amt = sc.nextInt();

            addToCart(choice, amt, products, stocks, cart);
        }

        sc.close();
    }
}
