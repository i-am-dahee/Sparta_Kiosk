package kiosk01;

public enum UserType {
    NATIONAL_HERO(0.1),
    SOLDIER(0.05),
    STUDENT(0.03),
    COMMON(0.0);

    private final double discountRate;

    UserType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
