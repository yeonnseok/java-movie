package domain;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {
    private static List<Movie> movies;

    static {
        movies = new ArrayList<>(
                Arrays.asList(
                        new Movie("기생충", Duration.ofMinutes(110), Money.wons(10000L), new AmountDiscountPolicy()),
                        new Movie("X-Man", Duration.ofMinutes(120), Money.wons(12000L), new AmountDiscountPolicy()),
                        new Movie("StarWars", Duration.ofMinutes(135), Money.wons(12000L), new PercentDiscountPolicy()),
                        new Movie("Avengers", Duration.ofMinutes(144), Money.wons(11000L), new PercentDiscountPolicy())
                )
        );
    }

    public static List<Movie> movies() {
        return movies;
    }
}
