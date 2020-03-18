package view;

import domain.Movie;
import domain.Screening;

import java.util.List;

public class OutputView {

    private static final String SPACE = " ";

    public static void printListOfMovies(List<Movie> movies) {
        movies.stream()
                .map(movie -> movie.getIndex() +
                        SPACE + movie.getTitle()+
                        SPACE + movie.getRunningTime() +
                        SPACE + movie.getFee())
                .forEach(System.out::println);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printListOfScreenings(List<Screening> screenings, Movie selectedMovie) {
        screenings.stream()
                .filter(screening -> screening.isSameMovie(selectedMovie))
                .map(screening -> screening.getMovieTitle() +
                        SPACE + screening.getSequence() +
                        SPACE + screening.getStartTime().toString())
                .forEach(System.out::println);
    }
}
