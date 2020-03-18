package domain;

import java.time.LocalDateTime;

public class Screening {
    private final Movie movie;
    private final int sequence;
    private final LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Money calculateTotalFee(AudienceCount audienceCount) {
        return movie.calculateDiscountedPrice(this)
                .times(audienceCount.getAudienceCount());
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }
}
