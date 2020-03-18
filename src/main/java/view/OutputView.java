package view;

import domain.Money;
import domain.Movie;
import domain.Screening;

import java.util.List;

public class OutputView {

    private static final String SPACE = " ";
    private static final String INPUT_MOVIE_INDEX_GUIDE_MESSAGE = "보고싶은 영화를 선택해주세요.";
    private static final String INPUT_SCREENING_SEQUENCE_GUIDE_MESSAGE = "보고싶은 회차를 선택해주세요.";
    private static final String INPUT_AUDIENCE_COUNT_GUIDE_MESSAGE = "예매 인원 수를 입력해 주세요.";

    public static void printInputMovieIndexGuideMessage() {
        System.out.println(INPUT_MOVIE_INDEX_GUIDE_MESSAGE);
    }

    public static void printListOfMovies(List<Movie> movies) {
        movies.stream()
                .map(movie -> movie.getIndex() +
                        SPACE + movie.getTitle()+
                        SPACE + movie.getRunningTime() +
                        SPACE + movie.getFee())
                .forEach(System.out::println);
    }

    public static void printInputScreeningSequenceGuideMessage() {
        System.out.println(INPUT_SCREENING_SEQUENCE_GUIDE_MESSAGE);
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

    public static void printInputAudienceCountGuideMessage() {
        System.out.println(INPUT_AUDIENCE_COUNT_GUIDE_MESSAGE);
    }

    public static void printTotalFee(Money calculateTotalFee) {
        System.out.println(String.format("결제금액은 %d원 입니다.", calculateTotalFee.getAmount()));
    }
}
