import java.util.Scanner;
import java.util.ArrayList;

// Starting point for the program
public class Main {

    // Create a new WHMS 
    private static WarehouseManagementSystem WHMS = new WarehouseManagementSystem();

    public static void main(String[] args) {

        // Adds some default suppliers at the start of the program
        createDummySuppliers();


        System.out.println("Welcome to BNU Industry Solution's Warehouse Management System (WHMS)!");

        // Open the scanner for user input 
        Scanner scanner = new Scanner(System.in);
        
        handleMainMenu(scanner);

        // Close out the scanner 
        scanner.close();
    }

    private static void createDummySuppliers(){
        WHMS.supplierManager.addContact(new Supplier("SuperBricksRUs", "sales@superbricks.com", null, null, "OX4 3TZ"));
        WHMS.supplierManager.addContact(new Supplier("Tom Drew", "tom@gmail.com", null, null, null));
        WHMS.supplierManager.addContact(new Supplier("SuperBricksRUs", "super@bricks.ru", null, null, null));
        WHMS.supplierManager.addContact(new Supplier("Screw4You", "bob@screws4you.co.uk", null, null, null));
    }

    private static void createDummyPurchaseOrders(){

    }
   
    private static String getStringInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()){
            System.out.println("Uh Oh! You did not enter anything. " + prompt);
            input = scanner.nextLine();
        }
        return input;
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

    private static double getPriceInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        double input = -1;
        while (input < 0) {
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                if (input < 0) {
                    System.out.println("Uh Oh! You entered a negative price. " + prompt);
                }
            } else {
                System.out.println("Uh Oh! You did not enter a valid price. " + prompt);
            }
        // Call nextLine to clear the newLine character in the scanner 
        scanner.nextLine();
        }
        return input;
    }

    private static String getNewSupplierEmailInput(Scanner scanner, String prompt){
        String input = getEmailInput(scanner, prompt);
        while (WHMS.supplierManager.findContactByEmail(input) != null) {
            System.out.println("Uh Oh! This email address is already in use. ");
            input = getEmailInput(scanner, prompt);
        }
        return input;
    }

     private static Supplier getExistingSupplierByEmail(Scanner scanner, String prompt){
        String input = getEmailInput(scanner, prompt);
        while (WHMS.supplierManager.findContactByEmail(input) == null) {
            System.out.println("Uh Oh! There is no Supplier with this email address. ");
            input = getEmailInput(scanner, prompt);
        }
        return WHMS.supplierManager.findContactByEmail(input);
    }

    private static String getNewItemNameInput(Scanner scanner, String prompt){
        String input = getStringInput(scanner, prompt);
        while (WHMS.findSupplierItemByName(input) != null) {
            System.out.println("Uh Oh! This Item is already being supplied by one of our Suppliers. ");
            input = getStringInput(scanner, prompt);
        }
        return input;
    }

    private static Item findItemfromSupplier(Scanner scanner, String prompt, Supplier supplier){
        String input = getStringInput(scanner, prompt);
        while (supplier.findItemByName(input) == null) {
            System.out.println("Uh Oh! There is no Item with this name address. ");
            input = getStringInput(scanner, prompt);
        }
        return supplier.findItemByName(input); 
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

    private static void handleMainMenu(Scanner scanner){
        switch (getMainMenuOption(scanner)){
                        case 1:
                            handleSupplierManagementMenu(scanner);
                        break;
                        case 2:
                        //handleCustomerManagementMenu(scanner);
                        break;
                        case 3:
                        //handleInventoryManagementMenu(scanner);
                        break;
                        case 4:
                        //handleOrderManagementMenu(scanner);
                        // place co, po,  
                        break;
                        case 5:
                        //handleFinanceManagementMenu(scanner);
                        break;
                        case 6:
                        // Exits the program
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
            };
    }

    private static int getSupplierManagementMenuOption(Scanner scanner){
        String menuText= "Please select the corresponding number (1-5) from the menu below:\n 1. View All Suppliers\n 2. Add New Supplier\n 3. Delete Supplier \n 4. Update Supplier Details \n 5. Back to Main Menu";
        System.out.println("\n----- Supplier Management ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 5, menuText);
    }

    private static void handleSupplierManagementMenu(Scanner scanner){
        switch (getSupplierManagementMenuOption(scanner)){
            case 1:
                displayAllSuppliers();
            break;
            case 2:
                addNewSupplier(scanner);
            break;
            case 3:
                deleteSupplier(scanner);
            break;
            case 4:
                updateSupplierDetails(scanner);
            break;
            case 5:
                handleMainMenu(scanner);
            break;
        }
        handleSupplierManagementMenu(scanner);
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
        String email = getNewSupplierEmailInput(scanner, "Please enter the Supplier's email address.");
        String phone = getPhoneNumberInput(scanner, "Please enter the Supplier's phone number.");
        String address = getStringInput(scanner, "Please enter the Supplier's address.");
        String postcode = getStringInput(scanner, "Please enter the Supplier's postcode.");

        try {
            WHMS.supplierManager.addContact(new Supplier(name, email, phone, address, postcode));
            System.out.println("Your new Supplier " + name + " has been successfully added!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! Something went wrong. We could not add your new Supplier to the system.");
        }
    }

    private static void deleteSupplier(Scanner scanner){
        System.out.println("\n----- Delete Supplier -----");
        Supplier supplier = getExistingSupplierByEmail(scanner, "Please enter the email address of the Supplier that you want to delete.");
        try {
            WHMS.supplierManager.deleteContact(supplier);
            System.out.println("The Supplier was successfully deleted!");
        } 
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to delete a Supplier with that email address from the system.");
        }
    }

    private static void updateSupplierDetails(Scanner scanner){
        Supplier supplier = getExistingSupplierByEmail(scanner, "Please enter the email address of the Supplier who's details you want to update.");
        handleUpdateSupplierDetailsMenu(scanner, supplier);

    }

    private static int getUpdateSupplierDetailsMenuOption(Scanner scanner, Supplier supplier){
        String menuText= "Please select the corresponding number (1-7) from the menu below:\n 1. Add a Supplier Item\n 2. Remove a Supplier Item\n 3. Update Supplier Name \n 4. Update Supplier Email \n 5. Update Supplier Phone Number \n 6. Update Supplier Address  \n 7. Back to Supplier Management";
        System.out.println("\n----- " + supplier.getName() + " Supplier Details ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 7, menuText);
    }

    private static void handleUpdateSupplierDetailsMenu(Scanner scanner, Supplier supplier){
        switch (getUpdateSupplierDetailsMenuOption(scanner, supplier)){
            case 1:
                addSupplierItem(scanner, supplier);
            break;
            case 2:
                removeSupplierItem(scanner, supplier);
            break;
            case 3:
                updateSupplierName(scanner, supplier);
            break;
            case 4:
                updateSupplierEmail(scanner, supplier);
            break;
            case 5:
                updateSupplierPhoneNumber(scanner, supplier);
            break;
            case 6:
                updateSupplierAddress(scanner, supplier);
            break;
            case 7:
                handleSupplierManagementMenu(scanner);
            break;
        }
        handleUpdateSupplierDetailsMenu(scanner, supplier);
    }

    private static void addSupplierItem(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Add Item Supplied By " + supplier.getName() + " -----\n");
        String itemName = getNewItemNameInput(scanner, "Please enter the name of the new item supplied by" + supplier.getName() + ".");
        String description = getStringInput(scanner, "Please enter a description for this new item.");
        double price = getPriceInput(scanner, "Please enter the unit price for this item.");
        try {
           Item newItem = new Item(itemName, description, price, supplier);
           supplier.addItem(newItem);
            System.out.println("The Supplier " + supplier.getName() + " is now a supplier of " + itemName + " items!");
        }
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to make this Supplier a supplier of the new item.");
        }

    }

    private static void removeSupplierItem(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Remove Item Supplied By " + supplier.getName() + " -----\n");
        Item item = findItemfromSupplier(scanner,"Please enter the name of item no longer supplied by this Supplier." , supplier);
        try {
            supplier.deleteItem(item);
            System.out.println("The Supplier item successfully removed!");
        } 
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to remove the Supplier item.");
        }

    }

    private static void updateSupplierName(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Update " + supplier.getName() + "'s Name -----\n");
        String oldName = supplier.getName();
        String newName = getStringInput(scanner, "Please enter the new name for this Supplier.");
        try {
            supplier.setName(newName);
            System.out.println("The Supplier's name was successfully updated from " + oldName + " to " + newName + "!");
        } 
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to update this Supplier's name.");
        }
    }

    private static void updateSupplierEmail(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Update " + supplier.getName() + "'s Email -----\n");
        String oldEmail = supplier.getEmail();
        String newEmail = getNewSupplierEmailInput(scanner, "Please enter the new email address for this Supplier.");
        try {
            supplier.setEmail(newEmail);
            System.out.println("The Supplier's email address was successfully updated from " + oldEmail + " to " + newEmail + "!");
        } 
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to update this Supplier's email.");
        }
    }

    private static void updateSupplierPhoneNumber(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Update " + supplier.getName() + "'s Phone Number -----\n");
        String oldPhone = supplier.getPhoneNumber();
        String newPhone = getPhoneNumberInput(scanner, "Please enter the new phone number for this Supplier.");
        try {
            supplier.setPhoneNumber(newPhone);
            System.out.println("The Supplier's phone number was successfully updated from " + oldPhone + " to " + newPhone + "!");
        } 
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to update this Supplier's phone number.");
        }

    }

    private static void updateSupplierAddress(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Update " + supplier.getName() + "'s Address -----\n");
        String address = getStringInput(scanner, "Please enter the new adddress for this Supplier.");
        String postcode = getStringInput(scanner, "Please enter the new postcode for this Supplier.");
        try {
            supplier.setAddress(address);
            supplier.setPostcode(postcode);
            System.out.println("The Supplier's address was successfully updated to" + address + ", " + postcode + "!");
        } 
        catch (Exception e){
            System.out.println(e + "Uh Oh! We were unable to update this Supplier's address.");
        }

    }

}
