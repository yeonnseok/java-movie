package domain;

import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private final List<DiscountCondition> discountConditions;

    public DefaultDiscountPolicy(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract Money getDiscountAmount(Screening screening);

}
