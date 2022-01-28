package optional.stream;

import java.util.Optional;

public class Person {
    private Optional<Car> car; // 사람이 차를 소유했을 수도 소유하지 않았을 수도 있으므로 Optional로 정의한다.
    public Optional<Car> getCar(){
        return car;
    }
    public Optional<Optional<Car>> getCarAsOptional(){
        return Optional.ofNullable(car);
    }
}


