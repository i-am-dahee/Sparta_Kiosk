package kiosk01;

public class Order {
    private final String id;
    private final double total;         // 총 금액
    private OrderStatus status;

    public Order(String id, double total) {
        this.id = id;
        this.total = total;
        this.status = OrderStatus.PENDING; // 기본 상태
    }

    // 총 금액
    public double getTotal() { return total; }

    // 상태 변경
    public void markPaid() { this.status = OrderStatus.PAID; }

    @Override
    public String toString() {
        return String.format("Order{id='%s', total=W %.1f, status=%s}", id, total, status);
    }
}