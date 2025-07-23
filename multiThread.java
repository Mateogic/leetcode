// 多线程打印
public class multiThread {
    private static int counter = 0;
    private static final int MAX_COUNT = 100;
    private static final Object lock = new Object();

    static class PrintTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (counter <= MAX_COUNT) 
                        System.out.println(Thread.currentThread().getName() + ": " + counter++);
                    else
                        break; // 计数器已超过最大值，退出循环
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask(), "线程1");
        Thread t2 = new Thread(new PrintTask(), "线程2");
        Thread t3 = new Thread(new PrintTask(), "线程3");

        t1.start();
        t2.start();
        t3.start();

        // 等待所有线程执行完毕
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
