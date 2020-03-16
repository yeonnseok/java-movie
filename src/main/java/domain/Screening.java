package domain;

import java.time.LocalTime;

public class Screening {
    private final Movie movie;
    private final int sequence;
    private final LocalTime whenScreened;

    public Screening(Movie movie, int sequence, LocalTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }
}
