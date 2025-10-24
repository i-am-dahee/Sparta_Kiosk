package kiosk01;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Kiosk {
    private final List<Menu> menus;
    private final Cart cart = new Cart();

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // start() 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            // 카테고리 출력
            System.out.println("[ MAIN MENU ]");
            IntStream.range(0, menus.size())
                    .forEach(i -> System.out.printf("%d. %s%n", i + 1, menus.get(i).getCategory()));
            System.out.println("0. 종료      | 종료");

            // 카테고리 입력
            int menuChoice = sc.nextInt();

            if (menuChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                System.exit(0);

            } else if (menuChoice >= 1 && menuChoice <= menus.size()) {

                Menu selectedMenu = menus.get(menuChoice - 1);

                // 세부 메뉴 반복 선택
                while (true) {

                    // 메뉴 출력
                    selectedMenu.printMenuItems();

                    // 메뉴 입력
                    int selectedItem = sc.nextInt();

                    if (selectedItem == 0) {
                        System.out.println("이전으로 돌아갑니다.\n");
                        break;

                    } else if (selectedItem >= 1 && selectedItem <= selectedMenu.size()) {

                        // 선택한 메뉴 출력
                        MenuItem item = selectedMenu.getItem(selectedItem - 1);
                        System.out.printf("%d. %s%n%n", selectedItem, item);

                        // 장바구니 기능
                        System.out.println("""
                                위 메뉴를 장바구니에 추가하시겠습니까?
                                1. 확인        2. 취소""");
                        int confirm = sc.nextInt();

                        if (confirm == 1) {
                            cart.addItem(item, 1);

                            while (true) {
                                cart.printCart();

                                // 주문 기능
                                System.out.println("""
                                        지금 주문하시겠습니까?
                                        1. 주문      | 장바구니를 확인 후 주문합니다.
                                        2. 계속 담기  | 진행 중인 주문을 취소합니다.
                                        3. 메뉴 삭제  | 장바구니 내역을 삭제합니다.""");
                                int next = sc.nextInt();

                                if (next == 1) {
                                    // 할인 기능
                                    Discount discount = new Discount();
                                    System.out.println("""
                                            \n할인 정보를 입력해주세요.
                                            1. 국가유공자 : 10%
                                            2. 군인     :  5%
                                            3. 학생     :  3%
                                            4. 일반     :  0%""");
                                    int selectedType = sc.nextInt();

                                    double total = cart.getTotal();
                                    double discountPrice = discount.getDiscount(total, selectedType);

                                    Order order = new Order("ORD-" + System.currentTimeMillis(), discountPrice);
                                    order.markPaid();
                                    System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n%n", discountPrice);
                                    cart.clear();
                                    break;
                                } else if (next == 2) {
                                    System.out.println("이전으로 돌아갑니다.\n");
                                    break;
                                } else if (next == 3) {
                                    System.out.println("\n삭제하실 메뉴 이름을 입력하세요.");
                                    String itemName = sc.next();
                                    sc.nextLine();

                                    boolean removed = cart.removeItem(itemName);

                                    if (removed) {
                                        System.out.println(itemName + " 1개가 장바구니에서 삭제되었습니다.");
                                    } else {
                                        System.out.println(itemName + "은 장바구니에 없는 항목입니다.");
                                    }
                                } else {
                                    System.out.println("유효하지 않은 선택입니다. 이전으로 돌아갑니다.\n");
                                }
                            }
                        } else if (confirm == 2) {
                            System.out.println("추가를 취소했습니다.\n");
                        } else {
                            System.out.println("유효하지 않은 선택입니다. 처음으로 돌아갑니다.\n");
                        }
                    } else {
                        System.out.println("유효하지 않은 선택입니다.\n");
                    }
                }
            } else {
                System.out.println("다시 입력해 주세요.\n");
            }
        }
    }
}
