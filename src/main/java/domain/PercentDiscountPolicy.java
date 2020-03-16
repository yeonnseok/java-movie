package domain;

import java.util.Arrays;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private final double discountRatio;

    public PercentDiscountPolicy(double discountRatio, DiscountCondition... discountConditions) {
        super(Arrays.asList(discountConditions));
        this.discountRatio = discountRatio;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(discountRatio);
    }
}
