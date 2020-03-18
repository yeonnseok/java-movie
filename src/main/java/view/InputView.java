package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMovieIndex() {
        OutputView.printInputMovieIndexGuideMessage();
        try {
            return inputIntValueWithValidation();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputMovieIndex();
        }
    }

    public static int inputScreeningSequence() {
        OutputView.printInputScreeningSequenceGuideMessage();
        try {
            return inputIntValueWithValidation();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputScreeningSequence();
        }
    }

    public static int inputAudienceCount() {
        OutputView.printInputAudienceCountGuideMessage();
        try {
            return inputIntValueWithValidation();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputAudienceCount();
        }
    }

    public static int inputPayment() {
        OutputView.printInputPaymentGuideMessage();
        try {
            return inputIntValueWithValidation();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputPayment();
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
