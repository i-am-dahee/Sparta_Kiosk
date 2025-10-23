package kiosk01;

public class CartItem {
    private MenuItem item;
    private int quantity;

    public CartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    // 수량 추가
    public void increaseQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    // 개별 항목 금액 계산
    public double getLineTotal() {
        String priceText = item.getPrice().replaceAll("[^\\d.]", ""); // 숫자만
        double price = Double.parseDouble(priceText);
        return price * quantity;
    }

    // 출력용 포맷 지정
    @Override
    public String toString() {
        return String.format("%s x %d개 = W %.1f",
                item.getName(), quantity, getLineTotal());
    }
}
