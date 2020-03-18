package controller;

import domain.Movie;
import domain.MovieRepository;
import domain.Screening;
import domain.ScreeningRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieReservation {
    private final List<Movie> movies = MovieRepository.movies();
    private final List<Screening> screenings = ScreeningRepository.screenings();

    public void run() {
        Movie selectedMovie = chooseMovie();
    }

    private Movie chooseMovie() {
        OutputView.printListOf(movies);
        return chooseMovieWithValidatedIndex();
    }

    private Movie chooseMovieWithValidatedIndex() {
        try {
            return movies.stream()
                    .filter(movie -> movie.isSameIndex(InputView.inputMovieIndex()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 영화입니다."));
        } catch(IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return chooseMovieWithValidatedIndex();
        }
    }
}
