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
        burgers.addItem(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("SmokeShack", "₩ 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Drinks 메뉴 추가
        drinks.addItem(new MenuItem("Shack-made Lemonade", "₩ 3.9", "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.addItem(new MenuItem("Fresh Brewed Iced Tea", "₩ 3.4", "직접 우린 아이스 티"));
        drinks.addItem(new MenuItem("Fifty/Fifty", "₩ 3.5", "레몬에이드와 아이스 티의 조화"));
        drinks.addItem(new MenuItem("Coca-Cola", "₩ 2.5", "톡 쏘는 코카콜라"));
        drinks.addItem(new MenuItem("Sprite", "₩ 2.5", "상쾌한 스프라이트"));

        // Desserts 메뉴 추가
        desserts.addItem(new MenuItem("Classic Ice Cream", "₩ 4.5", "바닐라, 초콜릿, 믹스 중 선택 가능"));
        desserts.addItem(new MenuItem("Shack Attack", "₩ 5.9", "초콜릿 퍼지, 쿠키 크럼블이 올라간 쉑어택 콘크리트"));
        desserts.addItem(new MenuItem("Vanilla Shake", "₩ 4.9", "부드럽고 진한 바닐라 쉐이크"));
        desserts.addItem(new MenuItem("Strawberry Shake", "₩ 4.9", "달콤한 딸기 쉐이크"));
        desserts.addItem(new MenuItem("Chocolate Shake", "₩ 4.9", "진한 초콜릿 맛 쉐이크"));

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}