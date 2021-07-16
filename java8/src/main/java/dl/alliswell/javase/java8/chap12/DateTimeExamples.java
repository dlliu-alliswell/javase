package dl.alliswell.javase.java8.chap12;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author: dlliu
 * @date_time: 2021/5/18 16:56
 * @description:
 */
public class DateTimeExamples {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcde");
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb);
        sb.append("fff");
        System.out.println(sb);

        Instant instant = Instant.ofEpochSecond(1622567554);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(localDateTime.format(dateTimeFormatter));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("dlasjflasdf");
        stringBuffer.append(123);
        System.out.println(stringBuffer);
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append(1);
        System.out.println(stringBuffer);
        String version = "5.5R8P1";
        version = version.substring(0, 5);
        System.out.println(version);


    }
}
