
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> temp = new ArrayList<>();
        boolean isOn = true;
        int count = 0;
        while (isOn) {
            temp.add("aaa");
            count += 1;
            System.out.println(count);
        }

       /* Integer[] array = new Integer[]{101, 20, 30, 50, 40};

        Map<Integer, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1, "one");
        hashMap.put(4, "four");
        hashMap.put(3, "two");
        hashMap.put(2, "zero");
        hashMap.putIfAbsent(2, "2012");

        System.out.println(hashMap);

        Runnable runnable = () -> {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + ":" + hashMap.get(i));
            }
        };

        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(13);
        list.add(1);
        list.addFirst(1);

        System.out.println(list);

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hashMap.put(5, "five");
        };

        Thread thread = new Thread(runnable);
        Thread threadTwo = new Thread(runnable2);
        thread.start();
        threadTwo.start();
        thread.join();
        threadTwo.join();
        System.out.println(hashMap);*/
    }
}
