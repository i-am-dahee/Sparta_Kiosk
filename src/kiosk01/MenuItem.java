package kiosk01;

public class MenuItem {
    String name;
    String price;
    String description;

    // 객체 생성
    public MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 출력용 포맷 지정
    @Override
    public String toString() {
        return String.format("%-15s | %-5s | %s", name, price, description);
    }
}
