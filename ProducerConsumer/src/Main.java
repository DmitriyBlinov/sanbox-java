import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(Runtime.getRuntime().availableProcessors());

        Producer producer = new Producer(blockingQueue);
        Consumer firstConsumer = new Consumer(blockingQueue);
        Consumer secondConsumer = new Consumer(blockingQueue);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            executor.execute(producer);
            executor.execute(firstConsumer);
            executor.execute(secondConsumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}