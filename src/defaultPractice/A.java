package defaultPractice;

public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
}
