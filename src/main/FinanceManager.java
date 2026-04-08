import java.time.Month;
import java.util.ArrayList;

/** 
 * The FinanceManager Class provides overall statistics about the company's monthly financial position. 
*/
public class FinanceManager {
    private OrderManager<SupplierOrder> supplierOrderManager;
    private OrderManager<CustomerOrder> customerOrderManager;

    public FinanceManager(OrderManager<SupplierOrder> supplierOrderManager, OrderManager<CustomerOrder> customerOrderManager){
        this.supplierOrderManager = supplierOrderManager;
        this.customerOrderManager = customerOrderManager;
    }

    /** Returns the total number of Supplier Orders placed in a given month.*/
    private int numberOfSupplierOrdersForMonth(int monthNumber){
        ArrayList<SupplierOrder> supplierOrders = this.supplierOrderManager.getOrdersForGivenMonth(monthNumber);
        return supplierOrders.size();
    }

    /** Returns the total number of Customer Orders placed in a given month. */
    private int numberOfCustomerOrdersForMonth(int monthNumber){
        ArrayList<CustomerOrder> customerOrders = this.customerOrderManager.getOrdersForGivenMonth(monthNumber);
        return customerOrders.size();
    }


    /** Returns the total amount that customers paid for products in a given month.*/
    private double calculateIncomeForMonth(int monthNumber){
        double totalIncome = 0;
        ArrayList<CustomerOrder> customerOrders = this.customerOrderManager.getOrdersForGivenMonth(monthNumber);
        for (CustomerOrder order : customerOrders){
            totalIncome += order.getTotalCost();
        }
        return totalIncome;
    }

    /** Returns the total amount that BNU Industry Solutions paid suppliers in a given month.*/
    private double calculateExpensesForMonth(int monthNumber){
        double totalExpenses = 0;
        ArrayList<SupplierOrder> supplierOrders = this.supplierOrderManager.getOrdersForGivenMonth(monthNumber);
        for (SupplierOrder order : supplierOrders){
            totalExpenses += order.getTotalCost();
        }
        return totalExpenses;
    }

    /** Uses the income and expenses to calculate the net income for a given month.*/
    private double calculateNetIncomeForMonth(int monthNumber){
        double income = calculateIncomeForMonth(monthNumber);
        double expenses = calculateExpensesForMonth(monthNumber);
        return (income - expenses);
    }

    /** Uses the net income to determine whether the company made a profit, loss, or broke even in a given month.*/
    private FinancialStatus calculateFinancialStatusForMonth(int monthNumber){
        double netIncome = calculateNetIncomeForMonth(monthNumber);
        if (netIncome > 0 ){
            return FinancialStatus.PROFIT;
        } else if (netIncome < 0){
            return FinancialStatus.LOSS;
        }
        return FinancialStatus.BREAK_EVEN;

    }

    /** Gives a summary of all of the finanical statistics for a given month.*/
    public String generateMonthlyReport(int monthNumber){
        return "\n----- Financial Summary for " + Month.of(monthNumber) + " -----\n\n Number of Supplier Orders: " + this.numberOfSupplierOrdersForMonth(monthNumber) 
        + "\n Total Outgoings: £" + this.calculateExpensesForMonth(monthNumber) + "\n Number of Customer Orders: " + this.numberOfCustomerOrdersForMonth(monthNumber)
        + "\n Total Incomings: £" + this.calculateIncomeForMonth(monthNumber) + "\n Net Income: £" + this.calculateNetIncomeForMonth(monthNumber) + 
        "\n Financal Status: " + this.calculateFinancialStatusForMonth(monthNumber);
    }
    
}
