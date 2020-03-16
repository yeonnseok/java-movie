package movieReservation;

import domain.AmountDiscountPolicy;
import domain.Money;
import domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie("기생충", Duration.ofMinutes(110), Money.wons(9000L),
                new AmountDiscountPolicy(Money.wons(2000L)));
    }

    @DisplayName("금액 할인 정책 적용 후 할인된 영화 가격 확인")
    @Test
    void calculateDiscountedPriceTest() {
        Money discountedPrice = movie.calculateDiscountedPrice();
        assertThat(discountedPrice).isEqualTo(Money.wons(7000L));
    }
}
