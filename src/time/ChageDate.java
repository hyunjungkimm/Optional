package time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChageDate {
    public static void main(String[] args) {
        //절대적인 방식으로 LocalDate의 속성 바꾸기 - withAttribute
        LocalDate date1 = LocalDate.of(2017, 9, 21); //2017-09-21
        LocalDate date2 = date1.withYear(2011);//2011-09-21
        LocalDate date3 = date2.withDayOfMonth(25); //2011-09-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2); //2011-02-25

        //상대적인 방식으로 LocalDate 속성 바꾸기
        LocalDate date5 = date1.plusWeeks(1); //2017-09-28
        LocalDate date6 = date5.minusYears(6); //2011-09-28
        LocalDate date7 = date6.plus(6, ChronoUnit.MONTHS);//2012-03-28

        //LocalDate 조정
        LocalDate date = LocalDate.of(2014,3,18);//2014-03-18
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);//2014-09-18
        date = date.plusYears(2).minusDays(10); //2016-09-08
        date.withYear(2011);//변수에 할당x - 영향x

    }
}
