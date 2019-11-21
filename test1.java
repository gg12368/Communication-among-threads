import java.util.Scanner;

public class Demo0 {
        private static Object object=new Object();
        public static class MyThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
                synchronized (object) {
                    try {
                        object.wait();//哪个线程调用wait，哪个线程放入等待集中
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 100; i < 110; i++) {
                    System.out.println(i);
                }
            }
        }
        public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入点东西");
        sc.nextLine();
        synchronized (object){
            object.notify();//notify只唤醒一个，但是不保证是哪一个
        }
    }
}
