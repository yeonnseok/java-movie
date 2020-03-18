package domain;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    private final int index;
    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(int index, String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.index = index;
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateDiscountedPrice(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public boolean isSameIndex(int targetIndex) {
        return index == targetIndex;
    }

    public Money getFee() {
        return fee;
    }

    public String getTitle() {
        return title;
    }

    public String getRunningTime() {
        return runningTime.toString();
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return index == movie.index &&
                Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, title);
    }
}
