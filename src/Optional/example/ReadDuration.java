package Optional.example;

import java.util.Optional;
import java.util.Properties;

public class ReadDuration {
    public int readDuration(Properties props, String name){
        String value = props.getProperty(name);
        if(value != null){//요청한 이름에 해당하는 프로퍼티가 존재하는지 확인한다.
            try{
                int i = Integer.parseInt(value);//문자열 프로퍼티를 숫자로 변환하기 위해 시도한다.
                if(i>0){//결과 숫자가 양수인지 확인한다.
                    return i;
                }
            }catch(NumberFormatException nfe){ }
        }
        return 0;//하나의 조건이라도 실패하면 0을 반환한다.
    }

   /* public int readDuration2(Properties props, String name){
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i>0)
                .orElse(0);
    }*/
}
