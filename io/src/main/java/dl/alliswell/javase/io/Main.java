package dl.alliswell.javase.io;

import java.io.File;
import java.io.IOException;

/**
 * @author: dlliu
 * @date_time: 2020/8/7 13:14
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("F:/a.txt");
        try {
            boolean result = file.createNewFile();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file);

        Integer a = 1;
        System.out.println(a instanceof Object);

    }
}
