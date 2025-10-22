package kiosk01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();

        // 카테고리 설정
        Menu burgers = new Menu("Burgers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        // 카테고리 추가
        menus.add(burgers);
        menus.add(drinks);
        menus.add(desserts);

        // Burgers 메뉴 추가
        burgers.menuItems.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.menuItems.add(new MenuItem("SmokeShack", "₩ 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.menuItems.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.menuItems.add(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}