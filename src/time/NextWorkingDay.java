package time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {

        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));//현재 날짜 읽기
        int dayToAdd = 1; //보통은 하루 추가
        if(dow == DayOfWeek.FRIDAY) dayToAdd = 3; //오늘일 금요일이면 3일추가
        else if(dow == DayOfWeek.SATURDAY) dayToAdd = 2; //토요일이면 2일 추가

        return temporal.plus(dayToAdd, ChronoUnit.DAYS);// 적정한 날 수만큼 추가된 날짜 반환

    }
}
