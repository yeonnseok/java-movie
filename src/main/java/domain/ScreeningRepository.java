package domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScreeningRepository {
    private static List<Screening> screenings;

    static {
        screenings = new ArrayList<>(
                Arrays.asList(
                        new Screening(MovieRepository.movies().get(0), 1, LocalTime.now()),
                        new Screening(MovieRepository.movies().get(0), 2, LocalTime.now()),
                        new Screening(MovieRepository.movies().get(0), 3, LocalTime.now()),
                        new Screening(MovieRepository.movies().get(1), 1, LocalTime.now()),
                        new Screening(MovieRepository.movies().get(1), 2, LocalTime.now()),
                        new Screening(MovieRepository.movies().get(2), 1, LocalTime.now()),
                        new Screening(MovieRepository.movies().get(3), 1, LocalTime.now())
                )
        );
    }

    public static List<Screening> screenings() {
        return screenings;
    }
}
