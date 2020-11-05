package dl.alliswell.javase.thread.threadLocal;

/**
 * @author: dlliu
 * @date_time: 2020/11/4 9:09
 * @description:
 */
public class Service {
    private static final ThreadLocal<String> user = new ThreadLocal<>();
    private static final Service service= new Service();
    private Service() {}

    public static Service getInstance() {
        return service;
    }

    public void process() {
        String userName = user.get();
        if (userName != null) {
            System.out.println(Thread.currentThread().getName() + " user name:" + userName);
        }
    }

    public void setUser(String userName) {
        user.set(userName);
    }

    public void removeUser() {
        user.remove();
    }
}
