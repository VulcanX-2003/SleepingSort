import java.util.concurrent.CyclicBarrier;

class SleepingSort extends Thread {

    public static void main(String[] args) {
        int[] array = {5, 3, 9, 1, 8, 6, 2, 7, 4};

        SleepingSort ob = new SleepingSort();

        ob.customSort(array);
    }

    void customSort(int[] arr) {
        final CyclicBarrier gate = new CyclicBarrier(arr.length + 1);
        Thread[] threads = new Thread[arr.length];

        for (int i = 0; i < arr.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                try {
                    gate.await(); // Wait for all threads to be ready
                    Thread.sleep(arr[index]);
                    System.out.print(arr[index] + " ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            gate.await(); // Start all threads
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All threads started");
    }
}
