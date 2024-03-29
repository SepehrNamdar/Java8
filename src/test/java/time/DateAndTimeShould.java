package time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
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

    @Test
    void change_date_format() {
        final LocalDateTime now = LocalDateTime.now();
        out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));
        out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
    }

    @Test
    void compare_dates() {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime nowPlusFiveDays = now.plusDays(5);

        assertThat(now.isBefore(nowPlusFiveDays)).isTrue();
        assertThat(nowPlusFiveDays.isAfter(now)).isTrue();
        assertThat(nowPlusFiveDays.isEqual(now)).isFalse();

        final Duration duration = Duration.between(now, nowPlusFiveDays);
        assertThat(duration).isEqualTo(Duration.ofDays(5));

        final LocalDate nowDate = LocalDate.now();
        final LocalDate nowDatePlusFiveDays = nowDate.plusDays(5);
        final Period period = Period.between(nowDate, nowDatePlusFiveDays);
        final int difference = period.getDays();
        assertThat(difference).isEqualTo(5);
    }
}
