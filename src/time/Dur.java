package time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Dur {
    public static void main(String[] args) {
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3,0);
        Instant.ofEpochSecond(2,1_000_000_000);
        Instant.ofEpochSecond(4,-1_000_000_000);

        /*
        Instant는 기계 전용의 유틸리티이다. - 사람이 읽을 수 있는 시간 정보를 제공하지 않는다.
        int day4 = Instant.now().get(ChronoField.DAY_OF_MONTH);
        System.out.println(day4);//UnsupportedTemporalTypeException


        //Duration - between
        LocalDateTime은 사람이 사용하도록, Instant는 기계가 사용하도록 만들어진 클래스로 두 인스턴스는 서로 혼합할 수 없다.
        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(instant1, instant2);
        */
        //between - 차이
        Period tenDays = Period.between(LocalDate.of(2017,9,11),
                                        LocalDate.of(2017,9,21));
        System.out.println(tenDays);//P10D

        //Duration과 Period만들기
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays2 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMontsOneDay = Period.of(2,6,1);

        System.out.println(threeMinutes + " , " + threeMinutes2);
        System.out.println(tenDays2);
        System.out.println(threeWeeks);
        System.out.println(twoYearsSixMontsOneDay);
    }
}
