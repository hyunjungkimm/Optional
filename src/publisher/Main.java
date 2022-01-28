package publisher;

public class Main {
    public static void main(String[] args) {
        ArithmeticCell c5 = new ArithmeticCell("C5");
        ArithmeticCell c3 = new ArithmeticCell("C3");

        SimpleCell c4 = new SimpleCell("C4");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c3.subscribe(c5::setLeft);
        c4.subscribe(c5::setRight);

        c1.onNext(10);//c1의 값을 10을 갱신
        c2.onNext(20);//c2의 값을 20을 갱신
        c1.onNext(15);//c1의 값을 15로 갱신
        c4.onNext(1);//c4의 값을 1으로 갱신
        c4.onNext(3);//c4의 값을 3으로 갱신
    }
}
