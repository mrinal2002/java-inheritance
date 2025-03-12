// Base class: Order
class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass: ShippedOrder extending Order
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking No: " + trackingNumber + ")";
    }
}

// Subclass: DeliveredOrder extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

// Main class to test the order hierarchy
public class RetailOrderSystem {
    public static void main(String[] args) {
        // Order placed
        Order order = new Order("ORD123", "2025-03-12");
        order.displayOrderDetails();
        System.out.println();

        // Order shipped
        ShippedOrder shippedOrder = new ShippedOrder("ORD123", "2025-03-12", "TRK987654");
        shippedOrder.displayOrderDetails();
        System.out.println();

        // Order delivered
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD123", "2025-03-12", "TRK987654", "2025-03-15");
        deliveredOrder.displayOrderDetails();
    }
}
