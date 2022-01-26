package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022,1,28);//2022-01-31
        /*date = date.with(new NextWorkingDay());
        System.out.println(date);*/

        //람다
        date = date.with(temporal -> {
            DayOfWeek dow =
                    DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if(dow == DayOfWeek.FRIDAY) dayToAdd = 3; //오늘일 금요일이면 3일추가
            else if(dow == DayOfWeek.SATURDAY) dayToAdd = 2; //토요일이면 2일 추가

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);// 적정한 날 수만큼 추가된 날짜 반환
        });

        System.out.println(date);
    }
}
