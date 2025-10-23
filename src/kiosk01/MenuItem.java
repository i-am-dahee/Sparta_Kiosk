package kiosk01;

public class MenuItem {
    private final String name;
    private final String price;
    private final String description;

    // 객체 생성
    public MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // getter/setter
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    // 출력용 포맷 지정
    @Override
    public String toString() {
        return String.format("%-15s | %-5s | %s", name, price, description);
    }
}
