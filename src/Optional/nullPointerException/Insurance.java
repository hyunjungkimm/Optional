package Optional.nullPointerException;

public class Insurance {
    private String name;
    public String getName(){
        return name;
    }
    /* 1. 차를 소유하지 않은 사람 - null 발생
    public String getCarInsuranceName(Person person){
        return person.getCar().getInsurance().getName();
    }
    2. 보수적인 자세로 NullPointerException 줄이기
    public String getInsuranceName(Person person){
        if(person != null){
            Car car = person.getCar();
            if(car != null){
                Insurance insurance = car.getInsurance();
                if (insurance != null){
                    return insurance.getName();
                }
            }
        }
        return "unKnown";
    }
     */
    //중첩 if블록 없애기  -> null 확인 코드마다 출구가 생긴다.
    public String getInsuranceName(Person person){
        if(person == null) return "UnKnown";

        Car car = person.getCar();
        if(car == null) return "UnKnown";

        Insurance insurance = car.getInsurance();
        if(insurance == null) return "UnKnown";

        return insurance.getName();
    }

}
