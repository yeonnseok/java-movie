package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieReservation {
    private final List<Movie> movies = MovieRepository.movies();
    private final List<Screening> screenings = ScreeningRepository.screenings();

    public void run() {
        Movie selectedMovie = chooseMovie();
        Screening selectedScreening = chooseScreening(selectedMovie);
        AudienceCount audienceCount = inputAudienceCountWithValidation();

        Payment payment = inputPaymentWithValidation(selectedScreening, audienceCount);
        if (payment.isNotCancel()) {
            Money finalTotalFee = payment.getFinalTotalFee(selectedScreening, audienceCount);
            OutputView.printFinalTotalFee(finalTotalFee);
            createReservation(selectedScreening, audienceCount, finalTotalFee);
        }
    }

    private Movie chooseMovie() {
        OutputView.printListOfMovies(movies);
        return chooseMovieWithValidatedIndex();
    }

    private Movie chooseMovieWithValidatedIndex() {
        try {
            int inputIndex = InputView.inputMovieIndex();
            return movies.stream()
                    .filter(movie -> movie.isSameIndex(inputIndex))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 영화입니다."));
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return chooseMovieWithValidatedIndex();
        }
    }

    private Screening chooseScreening(Movie selectedMovie) {
        OutputView.printListOfScreenings(screenings, selectedMovie);
        return chooseScreeningWithValidation(selectedMovie);
    }

    private Screening chooseScreeningWithValidation(Movie selectedMovie) {
        try {
            int inputSequence = InputView.inputScreeningSequence();
            return screenings.stream()
                    .filter(screening -> screening.isSameMovie(selectedMovie))
                    .filter(screening -> screening.isSequence(inputSequence))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회차입니다."));
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return chooseScreeningWithValidation(selectedMovie);
        }
    }

    private AudienceCount inputAudienceCountWithValidation() {
        try {
            return new AudienceCount(InputView.inputAudienceCount());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputAudienceCountWithValidation();
        }
    }

    private Payment inputPaymentWithValidation(Screening screening, AudienceCount audienceCount) {
        OutputView.printTotalFee(screening.calculateTotalFee(audienceCount));
        try {
            return Payment.of(InputView.inputPayment());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputPaymentWithValidation(screening, audienceCount);
        }
    }

    private void createReservation(Screening selectedScreening, AudienceCount audienceCount, Money finalTotalFee) {
        Reservation reservation = new Reservation(selectedScreening, audienceCount);
        OutputView.printReservation(reservation, finalTotalFee);
    }
}
