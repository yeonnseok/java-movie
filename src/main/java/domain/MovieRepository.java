package domain;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {
    public static List<Movie> movies;

    static {
        movies = new ArrayList<>(
                Arrays.asList(
                        new Movie(1, "기생충", Duration.ofMinutes(110), Money.wons(10000L),
                                new AmountDiscountPolicy(Money.wons(1000L),
                                        new SequenceCondition(1),
                                        new SequenceCondition(2),
                                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(7, 0), LocalTime.of(10, 0)))),
                        new Movie(2, "X-Man", Duration.ofMinutes(120), Money.wons(12000L),
                                new AmountDiscountPolicy(Money.wons(1500L),
                                        new SequenceCondition(1),
                                        new SequenceCondition(2))),
                        new Movie(3, "StarWars", Duration.ofMinutes(135), Money.wons(12000L),
                                new PercentDiscountPolicy(0.1,
                                        new SequenceCondition(1),
                                        new SequenceCondition(2))),
                        new Movie(4, "Avengers", Duration.ofMinutes(144), Money.wons(11000L),
                                new PercentDiscountPolicy(0.05,
                                        new SequenceCondition(1),
                                        new SequenceCondition(2)))
                )
        );
    }

    public static List<Movie> movies() {
        return movies;
    }
}
