package practice;

public class twentyFirst {
    public static void main(String[] args) {
        newThread newth = new newThread("新线程");
        Thread t1 = new Thread(newth);
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("名字：" + Thread.currentThread().getName() + " main");
        }
    }
}

class newThread implements Runnable {
    String threadName;

    public newThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("名字：" + Thread.currentThread().getName() + " new");
        }
    }
}
