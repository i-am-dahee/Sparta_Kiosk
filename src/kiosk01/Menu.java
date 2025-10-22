package kiosk01;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public String category;
    public List<MenuItem> menuItems;

    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }

    // 메뉴 출력 메서드
    public void printMenuItems() {
        System.out.println("\n[ BURGERS MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s%n", (i + 1), menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
    }
}
