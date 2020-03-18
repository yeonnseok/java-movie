package movieReservation;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ScreeningTest {
    private Movie movie;
    private Screening screening;
    private AudienceCount audienceCount;

    @BeforeEach
    void setUp() {
        movie = new Movie(1, "기생충", Duration.ofMinutes(110), Money.wons(9000L),
                new AmountDiscountPolicy(Money.wons(2000L), new SequenceCondition(1)));
        screening = new Screening(movie, 1, LocalDateTime.now());
        audienceCount = new AudienceCount(5);
    }

    @DisplayName("최종 금액 계산")
    @Test
    void calculateTotalFeeTest() {
        Money totalFee = screening.calculateTotalFee(audienceCount);
        assertThat(totalFee.getAmount()).isEqualTo(35000L);
    }
}
