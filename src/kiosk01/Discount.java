package kiosk01;

public class Discount {

    // 사용자 유형
    public UserType resolveType(int selectedType) {
        return switch (selectedType) {
            case 1 -> UserType.NATIONAL_HERO;
            case 2 -> UserType.SOLDIER;
            case 3 -> UserType.STUDENT;
            case 4 -> UserType.COMMON;
            default -> {
                System.out.println("유효하지 않은 입력입니다. 일반 고객으로 처리됩니다.\n");
                yield UserType.COMMON;
            }
        };
    }

    // 할인 적용 금액 계산
    private double applyDiscount(double originalPrice, UserType userType) {
        return originalPrice * (1 - userType.getDiscountRate());
    }

    // 할인 적용 금액 반환
    public double getDiscount(double originalPrice, int selectedType) {
        UserType userType = resolveType(selectedType);
        return applyDiscount(originalPrice, userType);
    }
}
