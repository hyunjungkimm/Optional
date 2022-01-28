package optional.optional;

import java.util.Optional;

public class Insurance {
    private String name;// 보험회사에는 반드시 이름이 있다.
    public String getName(){
        return name;
    }

    public String getCarInsuranceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UnKnown");// 결과 Optional이 비어있으면 기본값 사용
    }

}

