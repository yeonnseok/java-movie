package domain;

public class AmountDiscountPolicy implements DiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public Money calculateDiscountAmount() {
        return discountAmount;
    }
}
