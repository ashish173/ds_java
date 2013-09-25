// queue in java
import java.util.*;


public class queue {
    public static void main(String[] args) {
        Queue<Integer> queueA = new LinkedList<Integer>();
        queueA.offer(12);
        queueA.offer(13);
        System.out.println("First element is :" + queueA );
    }
}
