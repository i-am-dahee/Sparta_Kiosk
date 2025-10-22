package kiosk01;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

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
                System.exit(0);
            } else if (menuChoice >= 1 && menuChoice <= menus.size()) {

                // 메뉴 출력
                Menu selectedMenu = menus.get(menuChoice - 1);
                selectedMenu.printMenuItems();

                // 메뉴 입력
                int itemChoice = sc.nextInt();

                if (itemChoice == 0) {
                    System.out.println("[ MAIN MENU ] 로 돌아갑니다.\n");
                } else if (itemChoice >= 1 && itemChoice <= selectedMenu.size()) {
                    MenuItem item = selectedMenu.getItem(itemChoice - 1);
                    System.out.printf("%d. %s%n%n", itemChoice, item);
                } else {
                    System.out.println("다시 입력해 주세요.\n");
                }
            } else {
                System.out.println("다시 입력해 주세요.\n");
            }
        }
    }
}
