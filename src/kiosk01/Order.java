package kiosk01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final String id;
    private final List<CartItem> items; // 주문 당시 장바구니 스냅샷
    private final double total;         // 총 금액
    private final LocalDateTime createdAt;
    private OrderStatus status;

    public Order(String id, List<CartItem> snapshotItems, double total) {
        this.id = id;
        this.items = Collections.unmodifiableList(new ArrayList<>(snapshotItems));
        this.total = total;
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.PENDING; // 기본 상태
    }

    public String getId() { return id; }
    public List<CartItem> getItems() { return items; }
    public double getTotal() { return total; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public OrderStatus getStatus() { return status; }

    // 상태 변경
    public void markPaid() { this.status = OrderStatus.PAID; }
    public void cancel() { this.status = OrderStatus.CANCELLED; }

    @Override
    public String toString() {
        return String.format("Order{id='%s', total=W %.1f, status=%s}", id, total, status);
    }
}