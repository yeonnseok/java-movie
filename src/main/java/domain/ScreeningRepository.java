package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScreeningRepository {
    private static List<Screening> screenings;

    static {
        screenings = new ArrayList<>(
                Arrays.asList(
                        new Screening(MovieRepository.movies().get(0), 1, LocalDateTime.now()),
                        new Screening(MovieRepository.movies().get(0), 2, LocalDateTime.now()),
                        new Screening(MovieRepository.movies().get(0), 3, LocalDateTime.now()),
                        new Screening(MovieRepository.movies().get(1), 1, LocalDateTime.now()),
                        new Screening(MovieRepository.movies().get(1), 2, LocalDateTime.now()),
                        new Screening(MovieRepository.movies().get(2), 1, LocalDateTime.now()),
                        new Screening(MovieRepository.movies().get(3), 1, LocalDateTime.now())
                )
        );
    }

    public static List<Screening> screenings() {
        return screenings;
    }
}
