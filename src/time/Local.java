package time;

import java.time.*;
import java.time.temporal.ChronoField;

public class Local {
    public static void main(String[] args) {
        //LocalDate - 날짜
        LocalDate date = LocalDate.of(2017,9,21);//2017-09-21
        int year = date.getYear();//2017
        Month month = date.getMonth();//9
        int day = date.getDayOfMonth();//21
        DayOfWeek dow = date.getDayOfWeek();//Thursday
        int len = date.lengthOfMonth();// 31 (9월의 일수)
        boolean leap = date.isLeapYear(); //false (윤년이 아님)

        //시스템 시계의 정보를 이용해서 현재 날짜 정보를 얻는다
        LocalDate today = LocalDate.now();
        System.out.println(today);

        //TemporalField를 이용해서 LocalDate 값 읽기
        int year2 = date.get(ChronoField.YEAR);//2017
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);//9
        int day2 = date.get(ChronoField.DAY_OF_MONTH);//21

        //내장메서드
        int year3 = date.getYear();//2017
        int month3 = date.getMonthValue();//9
        int day3 = date.getDayOfMonth();//21

        System.out.println(year + " , " + year2 + " , "+year3);
        System.out.println(month + " , " + month2 + " , "+month3);
        System.out.println(day + " , " + day2 + " , "+day3);

        //LocalTime - 시간
        LocalTime time = LocalTime.of(13,45,20);// 13:45:20
        int hour = time.getHour();//13
        int minute = time.getMinute();//45
        int second = time.getSecond();//20

        System.out.println(hour + ":" + minute +":"+second);

        //문자열로 LocalDate, LocalTime의 인스턴스 만들기 - parse
        LocalDate date2 = LocalDate.parse("2017-09-21");
        LocalTime time2 = LocalTime.parse("13:45:20");
        System.out.println(date2 + " " + time2);

        //LocalDateTime을 직접 만드는 방법과 날짜와 시간을 조합하는 방법
        //2017-09-21T13:45:20
        LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13,45,20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();//2017-09-21
        LocalTime time1 = dt1.toLocalTime();//13:45:20



    }

}
