package publisher;

public interface Subscriber<T> {
    void onNext(T t);

}
