package publisher;

public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
