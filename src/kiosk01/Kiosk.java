package kiosk01;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;

    // 생성자를 통해 menuItems 값 할당
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // start() 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

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
