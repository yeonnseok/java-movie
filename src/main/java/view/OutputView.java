package view;

import domain.Movie;

import java.util.List;

public class OutputView {

    private static final String SPACE = " ";

    public static void printListOf(List<Movie> movies) {
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
}
