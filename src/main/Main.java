import java.util.Scanner;
import java.util.ArrayList;

// Starting point for the program
public class Main {

    // Create a new WHMS 
    private static WarehouseManagementSystem WHMS = new WarehouseManagementSystem();

    public static void main(String[] args) {

        // Adds some default data at the start of the program
        WHMS.createDummyData();


        System.out.println("Welcome to BNU Industry Solution's Warehouse Management System (WHMS)!");

        // Open the scanner for user input 
        Scanner scanner = new Scanner(System.in);
        
        handleMainMenu(scanner);

        // Close out the scanner 
        scanner.close();
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

    private static double getDoubleInput(Scanner scanner, String prompt, String doubleType){
        System.out.println(prompt);
        double input = -1;
        while (input < 0) {
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                if (input < 0) {
                    System.out.println("Uh Oh! You entered a negative " + doubleType + ". " + prompt);
                }
            } else {
                System.out.println("Uh Oh! You did not enter a valid " + doubleType + ". " + prompt);
            }
        // Call nextLine to clear the newLine character in the scanner 
        scanner.nextLine();
        }
        return input;
    }

    private static int getIntInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        int input = -1;
        while (input < 0){
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input < 1) {
                    System.out.println("Uh Oh! You did not enter a positive number. " + prompt);
                }
            } 
            else {
                System.out.println("Uh Oh! You did not enter a valid number. " + prompt);
            }
    
            // Call nextLine to clear the newLine character in the scanner 
            scanner.nextLine();
        }
        return input;

    }

    private static boolean getYesNoInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        String input = scanner.nextLine(); 
        while (true){
            if (input.equalsIgnoreCase("yes")) {
                return true;
            }
            else if (input.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Please enter yes or no. " + prompt);
                input = scanner.nextLine(); 
            }
        }
    }

    private static int getInStockQuantity(Scanner scanner, String prompt, InventoryStock stockItem){
        int quantity = getIntInput(scanner, prompt);
            while (!stockItem.enoughInStock(quantity)){
                System.out.println("Uh Oh! There are only " + stockItem.getCurrentStockLevel() + " " + stockItem.getName() + "s left in stock. ");
                quantity = getIntInput(scanner, prompt);
            }
        return quantity;
    }


    private static String getNewSupplierEmailInput(Scanner scanner, String prompt){
        String input = getEmailInput(scanner, prompt);
        while (WHMS.findSupplierByEmail(input) != null) {
            System.out.println("Uh Oh! This email address is already in use. ");
            input = getEmailInput(scanner, prompt);
        }
        return input;
    }

     private static Supplier getExistingSupplierByEmail(Scanner scanner, String prompt){
        String input = getEmailInput(scanner, prompt);
        while (WHMS.findSupplierByEmail(input) == null) {
            System.out.println("Uh Oh! There is no Supplier with this email address. ");
            input = getEmailInput(scanner, prompt);
        }
        return WHMS.findSupplierByEmail(input);
    }

    private static String getNewCustomerEmailInput(Scanner scanner, String prompt){
        String input = getEmailInput(scanner, prompt);
        while (WHMS.findCustomerByEmail(input) != null) {
            System.out.println("Uh Oh! This email address is already in use. ");
            input = getEmailInput(scanner, prompt);
        }
        return input;
    }

     private static Customer getExistingCustomerByEmail(Scanner scanner, String prompt){
        String input = getEmailInput(scanner, prompt);
        while (WHMS.findCustomerByEmail(input) == null) {
            System.out.println("Uh Oh! There is no Customer with this email address. ");
            input = getEmailInput(scanner, prompt);
        }
        return WHMS.findCustomerByEmail(input);
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
            System.out.println("Uh Oh! " + supplier.getName() + " does not supply any items with this name. ");
            input = getStringInput(scanner, prompt);
        }
        return supplier.findItemByName(input); 
    }

    private static InventoryStock findInventoryStockItem(Scanner scanner, String prompt){
        String input = getStringInput(scanner, prompt);
        while (WHMS.findInventoryStockItemByName(input) == null) {
            System.out.println("Uh Oh! There is no Item with this name. ");
            input = getStringInput(scanner, prompt);
        }
        return WHMS.findInventoryStockItemByName(input); 
    }

    private static SupplierOrder findOustandingSupplierOrderById(Scanner scanner, String prompt){
        int input = getIntInput(scanner, prompt);
        while (WHMS.findOutstandingSupplierOrderById(input) == null) {
            System.out.println("Uh Oh! We could not find an outstanding supplier order with an ID of " + input + ". ");
            input = getIntInput(scanner, prompt);
        }
        return WHMS.findOutstandingSupplierOrderById(input); 
    }

    private static CustomerOrder findOutstandingCustomerOrderById(Scanner scanner, String prompt){
        int input = getIntInput(scanner, prompt);
        while (WHMS.findOutstandingCustomerOrderById(input) == null) {
            System.out.println("Uh Oh! We could not find an outstanding customer order with an ID of " + input + ". ");
            input = getIntInput(scanner, prompt);
        }
        return WHMS.findOutstandingCustomerOrderById(input); 
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
                            handleCustomerManagementMenu(scanner);
                        break;
                        case 3:
                            handleInventoryManagementMenu(scanner);
                        break;
                        case 4:
                            handleOrderManagementMenu(scanner);
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
        String menuText= "Please select the corresponding number (1-6) from the menu below:\n 1. View All Suppliers\n 2. Add New Supplier\n 3. Delete Supplier \n 4. Update Supplier Details \n 5. View The Order History Of A Supplier \n 6. Back to Main Menu";
        System.out.println("\n----- Supplier Management ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 6, menuText);
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
                viewOrderHistoryOfSupplier(scanner);
            break;
            case 6:
                handleMainMenu(scanner);
            break;
        }
        handleSupplierManagementMenu(scanner);
    }

    private static void displayAllSuppliers(){
        System.out.println("\n----- All Suppliers -----\n");
        ArrayList<Supplier> suppliers = WHMS.getSuppliers();
        int index = 0;
        for (Supplier supplier : suppliers){
            index++;
            System.out.println(index + ". " + supplier.toString());
        }
    }

    private static void addNewSupplier(Scanner scanner){
        System.out.println("\n----- Add New Supplier -----\n");
        String name = getStringInput(scanner, "Please enter the Supplier's name.");
        String email = getNewSupplierEmailInput(scanner, "Please enter the Supplier's email address.");
        String phone = getPhoneNumberInput(scanner, "Please enter the Supplier's phone number.");
        String address = getStringInput(scanner, "Please enter the Supplier's address.");
        String postcode = getStringInput(scanner, "Please enter the Supplier's postcode.");

        try {
            WHMS.addSupplier(name, email, phone, address, postcode);
            System.out.println("Your new Supplier " + name + " has been successfully added!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! Something went wrong. We could not add your new Supplier to the system.");
        }
    }

    private static void deleteSupplier(Scanner scanner){
        System.out.println("\n----- Delete Supplier -----\n");
        Supplier supplier = getExistingSupplierByEmail(scanner, "Please enter the email address of the Supplier that you want to delete.");
        try {
            WHMS.deleteSupplier(supplier);
            System.out.println("The Supplier was successfully deleted!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to delete a Supplier with that email address from the system.");
        }
    }

    private static void updateSupplierDetails(Scanner scanner){
        Supplier supplier = getExistingSupplierByEmail(scanner, "Please enter the email address of the Supplier whose details you want to update.");
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
        double price = getDoubleInput(scanner, "Please enter the unit price for this item.", "price");
        try {
            WHMS.addSupplierItem(itemName, description, price, supplier);
            System.out.println("The Supplier " + supplier.getName() + " is now a supplier of " + itemName + " items!");
        }
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to make this Supplier a supplier of the new item.");
        }

    }

    private static void removeSupplierItem(Scanner scanner, Supplier supplier){
        System.out.println("\n----- Remove Item Supplied By " + supplier.getName() + " -----\n");
        Item item = findItemfromSupplier(scanner,"Please enter the name of item no longer supplied by this Supplier." , supplier);
        try {
            supplier.deleteItem(item);
            System.out.println(supplier.getName() + " is no longer a supplier of " +  item.getName() + " items!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to remove the Supplier item.");
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
            System.out.println("Uh Oh! We were unable to update this Supplier's name.");
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
            System.out.println("Uh Oh! We were unable to update this Supplier's email.");
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
            System.out.println("Uh Oh! We were unable to update this Supplier's phone number.");
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
            System.out.println("Uh Oh! We were unable to update this Supplier's address.");
        }

    }

    private static void viewOrderHistoryOfSupplier(Scanner scanner){
        Supplier supplier = getExistingSupplierByEmail(scanner, "Please enter the email address of the Supplier that you want to view the Order History of.");
        ArrayList<SupplierOrder> orderHistory = WHMS.getOrderHistoryOfSupplier(supplier);
        int index = 0;
        for (SupplierOrder order : orderHistory){
            index++;
            System.out.println(index + ". " + order.toString());
        }
    }

    private static int getCustomerManagementMenuOption(Scanner scanner){
        String menuText= "Please select the corresponding number (1-6) from the menu below:\n 1. View All Customers\n 2. Add New Customer\n 3. Delete Customer \n 4. Update Customer Details \n 5. View The Order History Of A Customer \n 6. Back to Main Menu";
        System.out.println("\n----- Customer Management ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 6, menuText);
    }

    private static void handleCustomerManagementMenu(Scanner scanner){
        switch (getCustomerManagementMenuOption(scanner)){
            case 1:
                displayAllCustomers();
            break;
            case 2:
                addNewCustomer(scanner);
            break;
            case 3:
                deleteCustomer(scanner);
            break;
            case 4:
                updateCustomerDetails(scanner);
            break;
            case 5:
                viewOrderHistoryOfCustomer(scanner);
            break;
            case 6:
                handleMainMenu(scanner);
            break;
        }
        handleCustomerManagementMenu(scanner);
    }

    private static void displayAllCustomers(){
        System.out.println("\n----- All Customers -----\n");
        ArrayList<Customer> customers = WHMS.getCustomers();
        int index = 0;
        for (Customer customer : customers){
            index++;
            System.out.println(index + ". " + customer.toString());
        }
    }

    private static void addNewCustomer(Scanner scanner){
        System.out.println("\n----- Add New Customer -----\n");
        String name = getStringInput(scanner, "Please enter the Customer's name.");
        String email = getNewCustomerEmailInput(scanner, "Please enter the Customer's email address.");
        String phone = getPhoneNumberInput(scanner, "Please enter the Customer's phone number.");
        String address = getStringInput(scanner, "Please enter the Customer's address.");
        String postcode = getStringInput(scanner, "Please enter the Customer's postcode.");

        try {
            WHMS.addCustomer(name, email, phone, address, postcode);
            System.out.println("Your new Customer " + name + " has been successfully added!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! Something went wrong. We could not add your new Customer to the system.");
        }
    }

    private static void deleteCustomer(Scanner scanner){
        System.out.println("\n----- Delete Customer -----\n");
        Customer customer = getExistingCustomerByEmail(scanner, "Please enter the email address of the Customer that you want to delete.");
        try {
            WHMS.deleteCustomer(customer);
            System.out.println("The Customer was successfully deleted!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to delete a Customer with that email address from the system.");
        }
    }

    private static void updateCustomerDetails(Scanner scanner){
        Customer customer = getExistingCustomerByEmail(scanner, "Please enter the email address of the Customer whose details you want to update.");
        handleUpdateCustomerDetailsMenu(scanner, customer);

    }

    private static int getUpdateCustomerDetailsMenuOption(Scanner scanner, Customer customer){
        String menuText= "Please select the corresponding number (1-5) from the menu below:\n 1. Update Customer Name \n 2. Update Customer Email \n 3. Update Customer Phone Number \n 4. Update Customer Address  \n 5. Back to Customer Management";
        System.out.println("\n----- " + customer.getName() + " Supplier Details ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 5, menuText);
    }

    private static void handleUpdateCustomerDetailsMenu(Scanner scanner, Customer customer){
        switch (getUpdateCustomerDetailsMenuOption(scanner, customer)){
            case 1:
                updateCustomerName(scanner, customer);
            break;
            case 2:
                updateCustomerEmail(scanner, customer);
            break;
            case 3:
                updateCustomerPhoneNumber(scanner, customer);
            break;
            case 4:
                updateCustomerAddress(scanner, customer);
            break;
            case 5:
                handleCustomerManagementMenu(scanner);
            break;
        }
        handleUpdateCustomerDetailsMenu(scanner, customer);
    }


    private static void updateCustomerName(Scanner scanner, Customer customer){
        System.out.println("\n----- Update " + customer.getName() + "'s Name -----\n");
        String oldName = customer.getName();
        String newName = getStringInput(scanner, "Please enter the new name for this Customer.");
        try {
            customer.setName(newName);
            System.out.println("The Customer's name was successfully updated from " + oldName + " to " + newName + "!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to update this Customer's name.");
        }
    }

    private static void updateCustomerEmail(Scanner scanner,  Customer customer){
        System.out.println("\n----- Update " + customer.getName() + "'s Email -----\n");
        String oldEmail = customer.getEmail();
        String newEmail = getNewCustomerEmailInput(scanner, "Please enter the new email address for this Customer.");
        try {
            customer.setEmail(newEmail);
            System.out.println("The Customer's email address was successfully updated from " + oldEmail + " to " + newEmail + "!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to update this Customer's email.");
        }
    }

    private static void updateCustomerPhoneNumber(Scanner scanner,  Customer customer){
        System.out.println("\n----- Update " + customer.getName() + "'s Phone Number -----\n");
        String oldPhone = customer.getPhoneNumber();
        String newPhone = getPhoneNumberInput(scanner, "Please enter the new phone number for this Customer.");
        try {
            customer.setPhoneNumber(newPhone);
            System.out.println("The Customer's phone number was successfully updated from " + oldPhone + " to " + newPhone + "!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to update this Customer's phone number.");
        }

    }

    private static void updateCustomerAddress(Scanner scanner,  Customer customer){
        System.out.println("\n----- Update " + customer.getName() + "'s Address -----\n");
        String address = getStringInput(scanner, "Please enter the new adddress for this Customer.");
        String postcode = getStringInput(scanner, "Please enter the new postcode for this Customer.");
        try {
            customer.setAddress(address);
            customer.setPostcode(postcode);
            System.out.println("The Customer's address was successfully updated to" + address + ", " + postcode + "!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to update this Customer's address.");
        }

    }


    private static void viewOrderHistoryOfCustomer(Scanner scanner){
        Customer customer = getExistingCustomerByEmail(scanner, "Please enter the email address of the Customer that you want to view the Order History of.");
        ArrayList<CustomerOrder> orderHistory = WHMS.getOrderHistoryOfCustomer(customer);
        int index = 0;
        for (CustomerOrder order : orderHistory){
            index++;
            System.out.println(index + ". " + order.toString());
        }
    }

    private static int getInventoryManagementMenuOption(Scanner scanner){
        String menuText= "Please select the corresponding number (1-6) from the menu below:\n 1. View All Items In Stock \n 2. View All Items Low In Stock\n 3. View All Items Out Of Stock\n 4. Change An Item's 'Low In Stock' Threshold\n 5. Change An Item's Price Markup Multiplier\n 6. Back to Main Menu";
        System.out.println("\n----- Inventory Management ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 6, menuText);
    }

    private static void handleInventoryManagementMenu(Scanner scanner){
        switch (getInventoryManagementMenuOption(scanner)){
            case 1:
                displayItemsInStock();
            break;
            case 2:
                displayItemsLowInStock();
            break;
            case 3:
                displayItemsOutOfStock();
            break;
            case 4:
                editItemLowInStockThreshold(scanner);
            break;
            case 5:
                editItemMarkUpMultiplier(scanner);
            break;
            case 6:
                handleMainMenu(scanner);
            break;
        }
        handleInventoryManagementMenu(scanner);
    }

    private static void displayInventoryItemsList(ArrayList<InventoryStock> items){
        int index = 0;
        for (InventoryStock item : items){
            index++;
            System.out.println(index + ". " + item.toString());
        }
    }

    private static void displayItemsInStock(){
        System.out.println("\n----- Items In Stock -----\n");
        ArrayList<InventoryStock> items = WHMS.getInStockItems();
        displayInventoryItemsList(items);
    }

    private static void displayItemsLowInStock(){
        System.out.println("\n----- Items Low In Stock -----\n");
        ArrayList<InventoryStock> items = WHMS.getLowInStockItems();
        displayInventoryItemsList(items);
    }

    private static void displayItemsOutOfStock(){
        System.out.println("\n----- Items Out Of Stock -----\n");
        ArrayList<InventoryStock> items = WHMS.getOutOfStockItems();
        displayInventoryItemsList(items);
    }

    private static void editItemLowInStockThreshold(Scanner scanner){
        System.out.println("\n----- Change Low In Stock Threshold -----\n");
        InventoryStock stockItem = findInventoryStockItem(scanner,"Please enter the name of item that you want to change the 'Low In Stock' threshold of.");
        int threshold = getIntInput(scanner, "Please enter the new number for the 'Low In Stock' threshold.");
        try {
            stockItem.setLowInStockThreshold(threshold);
            System.out.println("The 'Low In Stock' threshold has been successfully changed to " + threshold + " or less items left!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to change the 'Low In Stock' threshold. It is still set to " + stockItem.getLowStockThreshold() + " or less items.");
        }
    }

    private static void editItemMarkUpMultiplier(Scanner scanner){
        System.out.println("\n----- Change Mark Up Multiplier -----\n");
        InventoryStock stockItem = findInventoryStockItem(scanner,"Please enter the name of item that you want to change the mark-up multiplier of.");
        double multiplier = getDoubleInput(scanner, "Please enter the new mark-up multiplier that will be used to calculate this item's re-sale price.", "mark-up multiplier");
        try {
            stockItem.setMarkUpMultiplier(multiplier);
            System.out.println("The mark-up multiplier has been successfully changed to " + multiplier + "x the average purchase price of this item!");
        } 
        catch (Exception e){
            System.out.println("Uh Oh! We were unable to change the mark up multiplier for this item. It is still set to " + stockItem.getMarkUpMultiplier() + "x the average purchase price.");
        }
        
    }

    private static int getOrderManagementMenuOption(Scanner scanner){
        String menuText= "Please select the corresponding number (1-7) from the menu below:\n 1. View Outstanding Supplier Orders\n 2. View Outstanding Customer Orders\n 3. Place New Supplier Order \n 4. Place New Customer Order \n 5. Mark Supplier Order As Delivered \n 6. Mark Customer Order As Delivered \n 7. Back to Main Menu";
        System.out.println("\n----- Order Management ----- \n\nWhat would you like to do?\n" + menuText);
        return getNumberOption(scanner, 7, menuText);
    }

    private static void handleOrderManagementMenu(Scanner scanner){
        switch (getOrderManagementMenuOption(scanner)){
            case 1:
               displayOutstandingSupplierOrders();
            break;
            case 2:
                displayOutstandingCustomerOrders();
            break;
            case 3:
                placeSupplierOrder(scanner);
            break;
            case 4:
                placeCustomerOrder(scanner);
            break;
            case 5:
                markSupplierOrderDelivered(scanner);
            break;
            case 6:
                markCustomerOrderDelivered(scanner);
            break;
            case 7:
                handleMainMenu(scanner);
            break;
        }
        handleOrderManagementMenu(scanner);
    }

    private static void displayOutstandingSupplierOrders(){
        System.out.println("\n----- Outstanding Supplier Orders -----\n");
        ArrayList<SupplierOrder> orders = WHMS.getOutstandingSupplierOrders();
        int index = 0;
        for (SupplierOrder order : orders){
            index++;
            System.out.println(index + ". " + order.toString());
        }
    }

    private static void displayOutstandingCustomerOrders(){
        System.out.println("\n----- Outstanding Customer Orders -----\n");
        ArrayList<CustomerOrder> orders = WHMS.getOutstandingCustomerOrders();
        int index = 0;
        for (CustomerOrder order : orders){
            index++;
            System.out.println(index + ". " + order.toString());
        }
    }

    private static void placeSupplierOrder(Scanner scanner){
        System.out.println("\n----- Place Supplier Order -----\n");
        Supplier supplier = getExistingSupplierByEmail(scanner, "Please enter the email address of the Supplier that you would like to buy from.");
        ArrayList<QuantityItem> basket = new ArrayList<>();
        boolean addAnother = true;

        while (addAnother){
            Item item = findItemfromSupplier(scanner, "Please enter the name of the item that you want to purchase from " + supplier.getName() + ".", supplier);
            int quantity = getIntInput(scanner, "How many " + item.getName() + "s would you like to order?");
            try {
                basket.add(new QuantityItem(item, quantity));
                System.out.println(quantity + " " + item.getName() + "s have been added to your order!");
            }
            catch (Exception e){
                System.out.println("Uh Oh! We were unable to add " + quantity + " " + item.getName() + "s to your order.");

            }

            addAnother = getYesNoInput(scanner, "Would you like to buy any other items from this Supplier?");

        }
    
        try {
            WHMS.placeSupplierOrder(supplier, basket);
            System.out.println("Your order from " + supplier.getName() + " has has been sucessfully placed.");

        }
        catch (Exception e){
            
            System.out.println("Uh Oh! We were unable to place your order.");

        }

    }
    
    private static void placeCustomerOrder(Scanner scanner){
        System.out.println("\n----- Place Customer Order -----\n");
        Customer customer = getExistingCustomerByEmail(scanner, "Please enter the email address of the Customer that would like to make an order.");
        ArrayList<SellItem> basket = new ArrayList<>();
        boolean addAnother = true;
        while (addAnother){
            InventoryStock stockItem = findInventoryStockItem(scanner, "Please enter the name of the item that you woud like to buy.");
            if (!stockItem.isOut()){
                int quantity = getInStockQuantity(scanner, "How many " + stockItem.getName() + "s would you like to buy?", stockItem);
                SellItem sellItem = new SellItem(stockItem.getName(), stockItem.getDescription(), stockItem.getAveragePurchasePrice(), stockItem.getSupplier(), quantity, stockItem.getCurrentSellPrice());
                basket.add(sellItem);
            }
            else {
                System.out.println("Uh Oh! This item is currently out of stock.");
            }
    
            addAnother = getYesNoInput(scanner, "Would you like to buy any other items?");
        }
    
        try {

            WHMS.placeCustomerOrder(customer, basket);
            System.out.println("We have sucessfully placed an order for " + customer.getName() + ".");

        
        }
        catch (Exception e){

            System.out.println("Uh Oh! We were unable to place your order.");

        }
    }


    private static void markSupplierOrderDelivered(Scanner scanner){
        System.out.println("\n----- Mark Supplier Order Delivered -----\n");
        SupplierOrder order = findOustandingSupplierOrderById(scanner, "Please enter the Order ID of the supplier order that has arrived");
        try {

            WHMS.markSupplierOrderAsDelivered(order);
            System.out.println("Order " + order.getId() + " has been sucessfully marked as delivered.");

        }
        catch (Exception e){

            System.out.println("Uh Oh! We were unable to mark Order " + order.getId() + " as delivered.");

        }

    }

    private static void markCustomerOrderDelivered(Scanner scanner){
        System.out.println("\n----- Mark Customer Order Delivered -----\n");
        CustomerOrder order = findOutstandingCustomerOrderById(scanner, "Please enter the Order ID of the customer order that has been delivered");
        try {
            
            WHMS.markCustomerOrderAsDelivered(order);
            System.out.println("Order " + order.getId() + " has been successfully marked as delivered.");

        }
        catch (Exception e){

            System.out.println("Uh Oh! We were unable to mark Order " + order.getId() + " as delivered.");

        }

    }
    
}
