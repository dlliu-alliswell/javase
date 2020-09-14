package dl.alliswell.javase.base.json.bean;

import lombok.Data;

/**
 * @author: dlliu
 * @date_time: 2020/9/7 13:31
 * @description:
 */
@Data
public class Code {
    private int id;
    private int pid;
    private String path;
    private int level;
    private String name;
    private String nameEn;
    private String code;
}
