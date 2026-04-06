 /**
 * The OrderStatus class is used to return whether an order has been placed (ordered) or has arrived at its destination (delivered)
 * SupplierOrders are delivered to our Warehouse while CustomerOrders are delivered to customer addresses. 
 */
enum OrderStatus {
  ORDERED,
  DELIVERED
}