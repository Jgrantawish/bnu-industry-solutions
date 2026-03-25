import java.util.Scanner;
import java.util.ArrayList;

// Starting point for the program
public class Main {

    // Create a new WHMS 
    private static WarehouseManagementSystem WHMS = new WarehouseManagementSystem();

    public static void main(String[] args) {

        //Program is running
        boolean running = true;

        // Adds some default suppliers at the start of the program
        createDummySuppliers();


        System.out.println("Welcome to BNU Industry Solution's Warehouse Management System (WHMS)!");

        // Open the scanner for user input 
        Scanner scanner = new Scanner(System.in);
        
        while(running){
            // Get the selected main menu option and call the corresponding function for that number
            switch (getMainMenuOption(scanner)){
                        case 1:
                        handleSupplierManagementMenuOption(scanner);
                        break;
                        case 2:
                        //InventoryManagement(scanner);
                        break;
                        case 3:
                        //
                        break;
                        case 4:
                        //
                        break;
                        case 5:
                        //
                        break;
                        case 6:
                        // Exits the program
                        System.out.println("Goodbye!");
                        running = false;
                        break;
            };
        }

        // Close out the scanner 
        scanner.close();

    }

    private static void createDummySuppliers(){
        WHMS.supplierManager.addSupplier("SuperBricksRUs", "sales@superbricks.com", null, null, "OX4 3TZ");
        WHMS.supplierManager.addSupplier("Tom Drew", "tom@gmail.com", null, null, null);
        WHMS.supplierManager.addSupplier("SuperBricksRUs", null, null, null, null);
        WHMS.supplierManager.addSupplier("Screw4You", "bob@screws4you.co.uk", null, null, null);
    }

    private static void createDummyPurchaseOrders(){

    }
   
    private static String getStringInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private static String getEmailInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        String input = scanner.nextLine();
        while (!input.contains("@")) {
            System.out.println("Uh Oh! You did not enter an email address containing an '@' symbol. " + prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    private static String getPhoneNumberInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        String input = scanner.nextLine();
        // Regex for strings containing digits 0 to 9, +, - and spaces
        while (!input.matches("[0-9+\\- ]+")){
            System.out.println("Uh Oh! You entered a phone number that contained letters or other symbols. " + prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    private static int getNumberOption(Scanner scanner, int maxMenuLength, String menuText){
        int option = 0;
        while (option < 1 || option > maxMenuLength){
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 1 || option > maxMenuLength){
                    System.out.println("Uh Oh! You did not enter a number between 1 and " + maxMenuLength + ". " + menuText);
                }
            } 
            else {
                System.out.println("Uh Oh! You did not enter a valid number. " + menuText);
            }
    
            // Call nextLine to clear the newLine character in the scanner 
            scanner.nextLine();
        }
        return option;
    }

    private static int getMainMenuOption(Scanner scanner){
        String menuText= "Please select the corresponding number (1-6) from the menu below:\n 1. Supplier Management\n 2. Customer Management\n 3. Inventory Management \n 4. Order Management \n 5. Finance Management \n 6. Exit";
        System.out.println("\n----- WHMS ----- \n\nWhich area of the WHMS would you like to access?\n" + menuText);
        return getNumberOption(scanner, 6, menuText);
    }

    private static int getSupplierManagementMenuOption(Scanner scanner){
        String menuText= "Please select the corresponding number (1-5) from the menu below:\n 1. View All Suppliers\n 2. Add New Supplier\n 3. Delete Supplier \n 4. Update Supplier Details \n 5. Back to Main Menu";
        System.out.println("\n----- Supplier Management ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 5, menuText);
    }

    private static void handleSupplierManagementMenuOption(Scanner scanner){
        switch (getSupplierManagementMenuOption(scanner)){
            case 1:
                displayAllSuppliers();
            break;
            case 2:
                addNewSupplier(scanner);
            break;
            case 3:
            //
            break;
            case 4:
            //
            break;
            case 5:
            //
            break;
        }
        getSupplierManagementMenuOption(scanner);
    }

    private static void displayAllSuppliers(){
        System.out.println("\n----- All Suppliers -----");
        ArrayList<Supplier> suppliers = WHMS.supplierManager.getContacts();
        int index = 0;
        for (Supplier supplier : suppliers){
            index++;
            System.out.println(index + ". " + supplier.toString());
        }
    }

    private static void addNewSupplier(Scanner scanner){
        System.out.println("\n----- Add New Supplier -----");
        String name = getStringInput(scanner, "Please enter the Supplier's name.");
        String email = getEmailInput(scanner, "Please enter the Supplier's email address.");
        String phone = getPhoneNumberInput(scanner, "Please enter the Supplier's phone number.");
        String address = getStringInput(scanner, "Please enter the Supplier's address.");
        String postcode = getStringInput(scanner, "Please enter the Supplier's postcode.");

        try {
            WHMS.supplierManager.addSupplier(name, email, phone, address, postcode);
            System.out.println("Your new Supplier " + name + " has been successfully added!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! Something went wrong. We could not add your new Supplier to the system.");
        }
    }

}
