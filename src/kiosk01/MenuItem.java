package kiosk01;

public class MenuItem {
    private String name;
    private String price;
    private String description;

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
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // 출력용 포맷 지정
    @Override
    public String toString() {
        return String.format("%-15s | %-5s | %s", name, price, description);
    }
}
