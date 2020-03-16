package movieReservation;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;


public class DiscountCondition {
    private Movie movie;
    private Screening screening;

    @BeforeEach
    void setUp() {
        movie = new Movie("기생충", Duration.ofMinutes(110), Money.wons(9000L),
                new AmountDiscountPolicy(Money.wons(2000L)));
        screening = new Screening(movie, 1, LocalTime.now());
    }

    @DisplayName("회차 할인 조건 확인")
    @Test
    void SequenceDiscountConditionTest() {
        SequenceCondition discountCondition = new SequenceCondition(1);
        assertThat(discountCondition.isSatisfiedBy(screening)).isTrue();
    }
}
