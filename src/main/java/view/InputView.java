package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMovieIndex() {
        try {
            return inputIntValueWithValidation();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputMovieIndex();
        }
    }

    public static int inputScreeningSequence() {
        try {
            return inputIntValueWithValidation();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputScreeningSequence();
        }
    }

    private static int inputIntValueWithValidation() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
