package movieReservation;

import domain.AudienceCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AudienceCountTest {

    @DisplayName("0이하 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void audienceCountRangeTest(int count) {
        assertThatThrownBy(() -> {
            new AudienceCount(count);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
