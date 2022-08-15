package time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.System.out;
import static java.util.Calendar.HOUR;
import static org.assertj.core.api.Assertions.assertThat;

public class DateAndTimeShould {

    // Thread safe

    @Test
    void get_current_time() {
        // Before Java 8 :
        final Date date = new Date();
        out.println(date);

        // From Java 8 :
        final LocalDateTime localDateTime = LocalDateTime.now();
        out.println(localDateTime);
        final LocalDate localDate = LocalDate.now();
        out.println(localDate);
        final LocalTime localTime = LocalTime.now();
        out.println(localTime);

        final LocalDateTime aFutureDate =
                LocalDateTime.of(2033, 5, 22, 10, 5);
        assertThat(aFutureDate).isAfter(LocalDateTime.now());
    }

    @Test
    void get_5_hours_later() {
        // Before Java 8 :
        Calendar calendar = new GregorianCalendar();
        calendar.add(HOUR, -5);
        final Date time = calendar.getTime();
        out.println(time);

        // From Java 8 :
        final LocalDateTime fiveHoursLater = LocalDateTime.now().minusHours(5);
        out.println(fiveHoursLater);
    }

    @Test
    void determine_if_a_date_is_in_a_weekend() {
        // Given
        final LocalDate localDate = LocalDate.of(2022, 8, 5);
        final Java8DateAndTime java8DateAndTime = new Java8DateAndTime();

        // When
        boolean isWeekend = java8DateAndTime.isWeekend(localDate);

        // Then
        assertThat(isWeekend).isTrue();
    }

    @Test
    void get_tehran_time() {
        final ZonedDateTime parisTime = ZonedDateTime.now();
        out.println(parisTime.toLocalDateTime());
        out.println(ZoneId.getAvailableZoneIds());
        final ZonedDateTime tehranTime = parisTime.withZoneSameInstant(ZoneId.of("Asia/Tehran"));
        out.println(tehranTime.toLocalDateTime());

        final OffsetDateTime now = OffsetDateTime.now();
        out.println(now.toLocalDateTime());
        out.println(ZoneOffset.getAvailableZoneIds());
        final OffsetDateTime tehranTimeWithOffset = now.withOffsetSameInstant(ZoneOffset.of("+04:30"));
        out.println(tehranTimeWithOffset.toLocalDateTime());
    }
}
