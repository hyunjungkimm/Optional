package chapter16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Method {

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop", 200);
        long start = System.nanoTime();
        //상점에 제품 가격 정보 요청
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //제품의 가격을 계산하는 동안
        doSomethingElse();

        //다른 상점 검색 등 다른 작업 수행
        try {
            //가격 정보가 있으면 Future에서 가격 정보를 읽고, 가격 정보가 없으면 가격 정보를
            //받을 때까지 블록한다.
            double price = futurePrice.get();
            System.out.println("Price is %.2f%n" +  price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs ");
    }

    private static void doSomethingElse() {
    }


}
