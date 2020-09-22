package dl.alliswell.javase.base.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dlliu
 * @date_time: 2020/9/18 15:52
 * @description:
 */
public class TimeUtil {

    public static String longToDateStr(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
