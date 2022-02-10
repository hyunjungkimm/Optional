package chapter16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String name;
    private double price;

    public Shop(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //동기 메서드 -> 비동기 메서드
    public Future<Double> getPriceAsync(String product){
        //계산 결과를 포함할 CompletableFuture를 생성한다.
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                //다른 스레드에서 비동기적으로 계산을 수행한다.
                double price = calculatePrice(product);
                //오랜 시간이 걸리는 계산이 완료되면 Future에 값을 설정한다.
                futurePrice.complete(price);
            } catch (Exception ex){
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        //계산 결과가 완료되길 기다리지 않고 Future를 반환한다.
        return futurePrice;
    }

    public Future<Double> getPriceAsync2(String product){
        return CompletableFuture.supplyAsync(()-> calculatePrice(product));
    }

    //1초 지연을 흉내 내는 메소드
    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    //getPrice 메서드의 지연 흉내 내기
    public double getPrice(String product){
        return calculatePrice(product);
    }

    private double calculatePrice(String product){
        delay();
        Random random = new Random();

        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
