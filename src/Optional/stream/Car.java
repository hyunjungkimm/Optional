package Optional.stream;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;//자동차 보험에 가입되어 있을 수도 가입되어 있지 않았을 수도 있으므로 Optional로 정의한다.
    public Optional<Insurance> getInsurance(){
        return insurance;
    }



}
