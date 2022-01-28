package optional.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        String name = null;
        if(insurance != null){
            name = insurance.getName();
        }

        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name2 = optInsurance.map(Insurance::getName);
        //Optional이 값을 포함하면 map의 인수로 제공된 함수가 값을 바꾼다. Optional이 비어 있으면 아무일도 일어나지 x


    }
}
