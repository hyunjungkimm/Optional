package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Format {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        String d1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20140318
        String d2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2014-03-18

        System.out.println(d1);
        System.out.println(d2);

        //parse - 문자열을 날짜 객체로 만들수 있다
        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date1);//2014-03-18
        System.out.println(date2);//2014-03-18

        //패턴으로 DateTimeFormmater 만들기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date3 = LocalDate.of(2017,3,18);
        String formattedDate = date3.format(formatter);
        LocalDate date4 = LocalDate.parse(formattedDate, formatter);
        System.out.println(formattedDate);
        System.out.println(date4);

        //지역화된 DateFormmater 만들기
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        String formattedDate2 = date3.format(italianFormatter);
        LocalDate date5 = LocalDate.parse(formattedDate2, italianFormatter);
        System.out.println(formattedDate2);
        System.out.println(date5);

        //DateTimeFormatter 만들기
        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        String formatterdDate3 = date3.format(italianFormatter2);
        System.out.println(formatterdDate3);
    }
}
