package kiosk01;

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

    // 장바구니 초기화
    public void clear() {
        cartItems.clear();
        System.out.println("장바구니가 초기화 되었습니다.");
    }

    // 총 금액 계산
    public double getTotal() {
        return cartItems.values().stream()
                .mapToDouble(CartItem::getLineTotal)
                .sum();
    }

    // 장바구니 삭제
    public boolean removeItem(String itemName) {
        if (itemName == null || itemName.isBlank()) return false;

        String target = itemName.trim();
        String matchedKey = null;

        for (String key : cartItems.keySet()) {
            if (key.equalsIgnoreCase(target)) {
                matchedKey = key;
                break;
            }
        }

        if (matchedKey == null) return false;

        CartItem cartItem = cartItems.get(matchedKey);
        cartItem.decreaseQuantity(1);

        if (cartItem.getQuantity() <= 0) {
            cartItems.remove(matchedKey);
        }

        return true;
    }
}
