package optional.exception;

import java.util.Optional;

public class stringToInt {

    public static Optional<Integer> stringToInt(String s){
        try {
            return Optional.of(Integer.parseInt(s));//문자열을 정수로 변환할 수 있으면 정수로 변환된 값을 포함하는 Optional을 반환한다.
        }catch (NumberFormatException e){
            return Optional.empty();//그렇지 않으면 빈 Optional을 반환한다.
        }
    }
}
