package domain;

public class AudienceCount {
    private static final int AUDIENCE_COUNT_LOWER_BOUND = 1;
    private static final String UNDER_LOWER_BOUND_EXCEPTION_MESSAGE = "예매 인원은 1이상 양수로 입력해주세요.";

    private final int audienceCount;

    public AudienceCount(int audienceCount) {
        if (audienceCount <= AUDIENCE_COUNT_LOWER_BOUND) {
            throw new IllegalArgumentException(UNDER_LOWER_BOUND_EXCEPTION_MESSAGE);
        }
        this.audienceCount = audienceCount;
    }

    public int getAudienceCount() {
        return audienceCount;
    }
}
