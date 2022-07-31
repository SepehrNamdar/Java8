package time;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.THURSDAY;

public class Java8DateAndTime {

    public boolean isWeekend(LocalDate aDate) {
        final DayOfWeek dayOfWeek = aDate.getDayOfWeek();
        return dayOfWeek.equals(FRIDAY) || dayOfWeek.equals(THURSDAY);
    }

}
