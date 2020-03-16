package movieReservation;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {
    private Movie movie;
    private Movie movie2;
    private Screening screening;
    private Screening screening2;

    @BeforeEach
    void setUp() {
        movie = new Movie("기생충", Duration.ofMinutes(110), Money.wons(9000L),
                new AmountDiscountPolicy(Money.wons(2000L)));
        movie2 = new Movie("스파이더맨", Duration.ofMinutes(100), Money.wons(10000L),
                new PercentDiscountPolicy(0.05));
        screening = new Screening(movie, 1, LocalDateTime.now());
        screening2 = new Screening(movie2, 1, LocalDateTime.now());
    }

    @DisplayName("금액 할인 정책 적용 후 할인된 영화 가격 확인")
    @Test
    void calculateAmountDiscountedPriceTest() {
        Money discountedPrice = movie.calculateDiscountedPrice(screening);
        assertThat(discountedPrice).isEqualTo(Money.wons(7000L));
    }

    @DisplayName("비율 할인 정책 적용 후 할인된 영화 가격 확인")
    @Test
    void calculatePercentDiscountedPriceTest() {
        Money discountedPrice = movie2.calculateDiscountedPrice(screening2);
        assertThat(discountedPrice.getAmount()).isEqualTo(9500L);
    }
}
