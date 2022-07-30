import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.System.out;

public class DateAndTimeShould {

    // Thread safe

    @Test
    void get_current_time() {
        // Before Java 8 :
        final Date date = new Date();
        out.println(date);

        // From Java 8 :
        final LocalDateTime now = LocalDateTime.now();
        out.println(now);
    }

    @Test
    void get_5_hours_later() {
        // Before Java 8 :
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, -5);
        final Date time = calendar.getTime();
        out.println(time);

        // From Java 8 :
        final LocalDateTime fiveHoursLater = LocalDateTime.now().minusHours(5);
        out.println(fiveHoursLater);
    }
}
