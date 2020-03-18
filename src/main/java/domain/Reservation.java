package domain;

import java.time.LocalDateTime;

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

    public LocalDateTime getStartTime() {
        return screening.getStartTime();
    }
}
