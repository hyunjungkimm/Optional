package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class Main {

    //모든 상점에 순차적으로 정보를 요구하는 함수
    public static List<String> findPrices(String product){
        List<Shop> shops = Arrays.asList(new Shop("BestPrice", 400),
            new Shop("LetsSaveBig" , 200),
            new Shop("MyFavoriteShop", 100),
            new Shop("BuyItAll", 300));
      /* 4067
        return shops.stream()
            .map(shop -> String.format("%s price is %.2f",
                shop.getName(), shop.getPrice(product)))
            .collect(toList());
      //메서드 병렬화 - 1038
        return shops.parallelStream()
            .map(shop -> String.format("%s price is %.2f",
                shop.getName(), shop.getPrice(product)))
            .collect(toList());
       */

        //CompletableFuture로 findPrices 구현하기 - 2061
        List<CompletableFuture<String>> priceFutures =
            shops.stream() //CompletableFuture로 각각의 가격을 비동기적으로 계산한다.
                .map(shop -> CompletableFuture.supplyAsync(
                    () -> shop.getName() + "price is " +
                        shop.getPrice(product)))
                .collect(toList());

        return priceFutures.stream()
            .map(CompletableFuture::join) //모든 비동기 동작이 끝나길 기다린다.
            .collect(toList());
    }


    //findPrices의 결과와 성능 확인
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(Main.findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs ");
    }

}
