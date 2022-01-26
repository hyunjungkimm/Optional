package time;

import java.time.*;
import java.util.TimeZone;

public class Zone {
    public static void main(String[] args) {

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        LocalDate date = LocalDate.of(2014, Month.MARCH, 28);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);
        System.out.println(timeFromInstant);
    }
}
