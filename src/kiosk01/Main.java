package kiosk01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        // MenuItem 추가
        menuItems.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "₩ 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) {

            // MenuItem 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.printf("%d. %s%n", (i + 1), menuItems.get(i));
            }
            System.out.println("0. 종료             | 종료");

            // 숫자 입력
            int choice = sc.nextInt();

            // 입력 받은 숫자에 따른 처리
            if (choice == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                System.exit(0);
            } else if (choice >= 1 && choice <= menuItems.size()) {
                MenuItem item = menuItems.get(choice - 1);
                System.out.printf("%d. %s%n%n", choice, item);
            } else {
                System.out.println("다시 입력해 주세요.\n");
            }
        }
    }
}