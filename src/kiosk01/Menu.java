package kiosk01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Menu {
    private final String category;
    private final List<MenuItem> items = new ArrayList<>();

    public Menu(String category) {
        this.category = category;
    }

    // 메뉴 추가
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // 특정 인덱스 조회
    public MenuItem getItem(int index) {
        return items.get(index);
    }

    // 메뉴 개수 반환
    public int size() {
        return items.size();
    }

    // getter/setter
    public String getCategory() {
        return category;
    }

    // 메뉴 출력 메서드
    public void printMenuItems() {
        System.out.printf("%n[ %s MENU ]%n", category.toUpperCase());
        IntStream.range(0, items.size())
                .forEach(i -> System.out.printf("%d. %s%n", i + 1, items.get(i)));
        System.out.println("0. 뒤로가기");
    }
}
