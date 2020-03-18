package view;

import domain.Money;
import domain.Movie;
import domain.Reservation;
import domain.Screening;

import java.util.List;

public class OutputView {

    private static final String SPACE = " ";
    private static final String NEWLINE = System.lineSeparator();
    private static final String INPUT_MOVIE_INDEX_GUIDE_MESSAGE = "보고싶은 영화를 선택해주세요.";
    private static final String INPUT_SCREENING_SEQUENCE_GUIDE_MESSAGE = "보고싶은 회차를 선택해주세요.";
    private static final String INPUT_AUDIENCE_COUNT_GUIDE_MESSAGE = "예매 인원 수를 입력해 주세요.";
    private static final String TOTAL_FEE_MESSAGE_FORMAT = "결제금액은 %d원 입니다.";
    private static final String INPUT_PAYMENT_GUIDE_MESSAGE = "카드는 1번 현금은 2번 취소는 3번을 눌러주세요.";
    private static final String FINAL_TOTAL_FEE_MESSAGE_FORMAT = "최종 %d 원을 결제합니다.";
    private static final String RESERVATION_CONTENTS_HEADER = "예매 내역";
    private static final String RESERVATION_CONTENTS_FORMAT = "%s %d회차 %d명 %d원으로 예약되었습니다.";


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
        System.out.println(String.format(TOTAL_FEE_MESSAGE_FORMAT, calculateTotalFee.getAmount()));
    }

    public static void printInputPaymentGuideMessage() {
        System.out.println(INPUT_PAYMENT_GUIDE_MESSAGE);
    }

    public static void printFinalTotalFee(Money finalTotalFee) {
        System.out.println(String.format(FINAL_TOTAL_FEE_MESSAGE_FORMAT, finalTotalFee.getAmount()));
    }

    public static void printReservation(Reservation reservation, Money finalTotalFee) {
        System.out.print(NEWLINE);
        System.out.println(RESERVATION_CONTENTS_HEADER);
        System.out.println(String.format(RESERVATION_CONTENTS_FORMAT,
                reservation.getMovieTitle(),
                reservation.getSequence(),
                reservation.getAudienceCount(),
                finalTotalFee.getAmount()));
    }

}
