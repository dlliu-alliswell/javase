package dl.alliswell.javase.thread.runnable;

/**
 * @author: dlliu
 * @date_time: 2020/9/16 17:19
 * @description:
 */
public class RunnableMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyTask(), "thread" + i);
            thread.start();
        }
    }
}
