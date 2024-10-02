package menu;

public class MenuUtils {

    public static void printMainMenu(){
        System.out.print("""
                1. Admin Menu
                2. Customer Menu
                3. Exit
                Choose an option:""");
    }

    public static void printAdminMenu(){
        System.out.print("""
                Admin Menu:
                1. Add Product
                2. Remove Product
                3. View Products
                4. Create Admin
                5. View Admins
                6. Update Order Status
                7. View Orders
                8. Return
                Choose an option: """);
    }

    public static void printCustomerMenu(){
        System.out.print("""
                Customer Menu:
                1. Create Customer
                2. View Customers
                3. Place Order
                4. View Orders
                5. View Products
                6. Return
                Choose an option: """);
    }
}
