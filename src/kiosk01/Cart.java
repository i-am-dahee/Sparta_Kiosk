package kiosk01;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private final Map<String, CartItem> cartItems = new LinkedHashMap<>(); // 메뉴명 기준으로 관리

    // 장바구니에 담기
    public void addItem(MenuItem item, int quantity) {
        if (cartItems.containsKey(item.getName())) {
            cartItems.get(item.getName()).increaseQuantity(quantity);
        } else {
            cartItems.put(item.getName(), new CartItem(item, quantity));
        }
        System.out.println(item.getName() + " " + quantity + "개가 장바구니에 추가되었습니다.");
    }

    // 장바구니 목록 출력
    public void printCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.\n");
            return;
        }

        System.out.println("\n[ CART ITEMS ]");
        double total = 0;

        for (CartItem item : cartItems.values()) {
            System.out.println("- " + item);
            total += item.getLineTotal();
        }

        System.out.printf("총 금액: W %.1f%n%n", total);
    }

    // 장바구니 비우기
    public void clear() {
        cartItems.clear();
        System.out.println("장바구니가 비워졌습니다.\n");
    }

    // 장바구니가 비었는지 확인
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    // 총 금액 계산
    public double getTotal() {
        return cartItems.values().stream()
                .mapToDouble(CartItem::getLineTotal)
                .sum();
    }

    // 장바구니 항목 전체 반환 (주문 기능에서 사용 예정)
    public Collection<CartItem> getItems() {
        return cartItems.values();
    }
}
