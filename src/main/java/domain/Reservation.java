package domain;

public class Reservation {
    private final Screening screening;
    private final AudienceCount audienceCount;

    public Reservation(Screening screening, AudienceCount audienceCount) {
        this.screening = screening;
        this.audienceCount = audienceCount;
    }

    public Money getTotalFee() {
        return screening.calculateTotalFee(audienceCount);
    }

    public String getMovieTitle() {
        return screening.getMovieTitle();
    }

    public int getSequence() {
        return screening.getSequence();
    }

    public int getAudienceCount() {
        return audienceCount.getAudienceCount();
    }
}
