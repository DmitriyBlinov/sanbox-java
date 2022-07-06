import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String temp = this.blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " consumed " + temp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}