package kiosk01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private Cart cart = new Cart();

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // start() 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            // 카테고리 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.printf("%d. %s%n", (i + 1), menus.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");

            // 카테고리 입력
            int menuChoice = sc.nextInt();

            if (menuChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                System.exit(0);

            } else if (menuChoice >= 1 && menuChoice <= menus.size()) {

                Menu selectedMenu = menus.get(menuChoice - 1);

                // 서브 메뉴 반복 선택
                menuItemLoop:
                while (true) {

                    // 메뉴 출력
                    selectedMenu.printMenuItems();

                    // 메뉴 입력
                    int itemChoice = sc.nextInt();

                    if (itemChoice == 0) {
                        System.out.println("[ MAIN MENU ] 로 돌아갑니다.\n");
                        break menuItemLoop;

                    } else if (itemChoice >= 1 && itemChoice <= selectedMenu.size()) {

                        // 선택한 메뉴 출력
                        MenuItem item = selectedMenu.getItem(itemChoice - 1);
                        System.out.printf("%d. %s%n%n", itemChoice, item);

                        // 장바구니 기능
                        System.out.println("""
                                장바구니에 추가할까요?
                                1. 확인        2. 취소""");
                        int confirm = sc.nextInt();

                        if (confirm == 1) {
                            cart.addItem(item, 1);
                            cart.printCart();

                            // 장바구니 메뉴 주문
                            System.out.println("""
                                지금 주문하시겠습니까?
                                1. 주문      2. 계속 담기      3. 메뉴판""");
                            int next = sc.nextInt();

                            if (next == 1) {
                                // 1. 주문
                                List<CartItem> snapshot = new ArrayList<>(cart.getItems());
                                double total = cart.getTotal();
                                Order order = new Order("ORD-" + System.currentTimeMillis(), snapshot, total);
                                order.markPaid();
                                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n%n", order.getTotal());
                                cart.clear();
                                break menuItemLoop;
                            } else if (next == 2) {
                                // 2. 계속 담기
                                continue menuItemLoop;
                            } else if (next == 3) {
                                // 3. 메뉴판
                                System.out.println("[ MAIN MENU ] 로 돌아갑니다.\n");
                                break menuItemLoop;
                            } else {
                                System.out.println("유효하지 않은 선택입니다. 이전으로 돌아갑니다.\n");
                                continue menuItemLoop;
                            }

                        } else if (confirm == 2) {
                            System.out.println("추가를 취소했습니다.\n");
                        } else {
                            System.out.println("유효하지 않은 선택입니다. 처음으로 돌아갑니다.\n");
                        }

                    } else {
                        System.out.println("다시 입력해 주세요.\n");
                    }
                }
            } else {
                System.out.println("다시 입력해 주세요.\n");
            }
        }
    }
}
