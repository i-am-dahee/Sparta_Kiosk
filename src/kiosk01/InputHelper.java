package kiosk01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    // 정수 타입에 문자열 입력 시 예외 처리
    public static int inputInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 선택입니다.\n");
            } finally {
                sc.nextLine();
            }
        }
    }

    // 문자열에 빈 칸 입력 시 예외 처리
    public static String inputString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = sc.nextLine().trim();

            if (!input.isBlank()) {
                return input;
            }

            System.out.println("유효하지 않은 선택입니다.\n");
        }
    }

}
