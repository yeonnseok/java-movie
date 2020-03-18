package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1, 0.0),
    CASH(2, 0.95),
    CANCEL(3, 0.0);

    private static final String PAYMENT_NOT_FOUND_EXCEPTION_MESSAGE = "1, 2, 3번 중에 선택해주세요.";

    private final int number;
    private final double discountRatio;

    Payment(int number, double discountRatio) {
        this.number = number;
        this.discountRatio = discountRatio;
    }

    public static Payment of(int targetNumber) {
        return Arrays.stream(values())
                .filter(payment -> payment.number == targetNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PAYMENT_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    public Money getFinalTotalFee(Screening screening, AudienceCount audienceCount) {
        return screening.calculateTotalFee(audienceCount).times(discountRatio);
    }

    public boolean isNotCancel() {
        return this != CANCEL;
    }
}
