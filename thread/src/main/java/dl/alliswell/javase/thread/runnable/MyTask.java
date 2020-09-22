package dl.alliswell.javase.thread.runnable;

/**
 * @author: dlliu
 * @date_time: 2020/9/16 17:17
 * @description:
 */
public class MyTask implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (i < 20) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
