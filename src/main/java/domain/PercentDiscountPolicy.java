package domain;

public class PercentDiscountPolicy implements DiscountPolicy {
    private final double discountRatio;

    public PercentDiscountPolicy(double discountRatio) {
        this.discountRatio = discountRatio;
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(discountRatio);
    }
}
