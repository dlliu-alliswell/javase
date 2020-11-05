package dl.alliswell.javase.thread.threadLocal;

/**
 * @author: dlliu
 * @date_time: 2020/11/4 9:09
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            Service service = Service.getInstance();
            service.setUser("bob");
            service.process();
            service.removeUser();
            service.process();
        }).start();

        new Thread(() -> {
            Service service = Service.getInstance();
            service.process();
            service.setUser("mary");
            service.process();
        }).start();
    }
}
