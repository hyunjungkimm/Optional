package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static chapter16.Shop.delay;
import static java.util.stream.Collectors.toList;

public class Discount {
    public enum Code{
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage){
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote){
        return quote.getShopName() + " price is " +
            Discount.apply(quote.getPrice(),//기존 가격에 할인 코드를 적용한다.
                           quote.getDiscountCode());
    }

    private static double apply(double price, Code code){
        delay(); // Discount 서비스의 응답 지연을 흉내낸다.
        return Double.parseDouble(String.format(String.valueOf(price * (100 - code.percentage) / 100)));
    }

        //모든 상점에 순차적으로 정보를 요구하는 함수
       /* public static List<String> findPrices(String product) {
            List<Shop> shops = Arrays.asList(new Shop("BestPrice", 400),
                new Shop("LetsSaveBig" , 200),
                new Shop("MyFavoriteShop", 100),
                new Shop("BuyItAll", 300));

            return shops.stream()
                .map(shop -> shop.getPrice(product))//각 상점에서 할인 전 가격 얻기
                .map(Quote::parse)// 상점에서 반환한 문자열을 Quoto 객체로 변환하기
                .map(Discount::applyDiscount)// Discount 서비스를 이용해서 각 Quoto에 할인을 적용하낟.
                .collect(toList());

        }*/

        /*public static List<String> findPrices(String product) {
            List<Shop> shops = Arrays.asList(new Shop("BestPrice", 400),
                new Shop("LetsSaveBig" , 200),
                new Shop("MyFavoriteShop", 100),
                new Shop("BuyItAll", 300));

            List<CompletableFuture<String>> priceFutures =
                shops.stream()
                    .map(shop-> CompletableFuture.supplyAsync(
                                                         ()-> shop.getPrice(product), executor))
                    .map(future -> future.thenApply(Quote::parse)
                    .map(future -> future.thenCompose(quote ->
                            CompletableFuture.supplyAsync(
                                ()-> Discount.applyDiscount(quote), executor)))
                    .collect(toList());


            return priceFutures.stream().map(CompletableFuture::join)
                .collect(toList());
*/
}
