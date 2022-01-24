package Optional.stream;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Insurance {
    private String name;// 보험회사에는 반드시 이름이 있다.
    public String getName(){
        return name;
    }

    //List<Person>을 인수로 받아 자동차를 소유한 사람들이 가입한 보험 회사의 이름을 포함하는 Set<String>을 반환하도록 메서드를 구현해야 한다
    public Set<String> getCarInsuranceName(List<Person> person){
        return person.stream()
                .map(Person::getCar)// 사람목록을 각 사람이 보유한 Optional<Car> 스트림으로 변환
                .map(optCar -> optCar.flatMap(Car::getInsurance))//FlatMap 연산을 이용해 Optional<Car>를 Optinal<Insurance>로 변환
                .map(optIns -> optIns.map(Insurance::getName))// Optional<Insurance>를 해당 이름의 Optional<String>으로 매핑
                .flatMap(Optional::stream)//Stream<Optional<String>>을 현재 이름을 포함하는 Stream<String>으로 변환
                .collect(toSet());//결과 문자열을 중복되지 않은 값을 갖도록 집합으로 수집

    }
  /*  public Insurance findCheapesInsurance(Person person, Car car){
        //다양한 보험회사가 제공하는 서비스 조회
        //ahems 결과 데이터 비교
        return cheapestCompany;
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car) {
        if(person.isPresent() && car.isPresent()){
            return Optional.of(findCheapesInsurance(person.get(), car.get()));
        }else{
            return Optional.empty();
        }
    }
   //Optional 언랩하지 않고 두 Optional 합치기
    public Optional<Insurance> nullSafeFindCheapestInsurance2(
            Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapesInsurance(p,c)));
    }*/



}

