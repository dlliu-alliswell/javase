package dl.alliswell.javase.base.json;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import dl.alliswell.javase.base.json.bean.Code;

import java.util.List;

/**
 * @author: dlliu
 * @date_time: 2020/9/7 13:37
 * @description:
 */
public class CanDataBuild {
    public static void main(String[] args) {
        final CsvReader reader = CsvUtil.getReader();
        final List<Code> result = reader.read(ResourceUtil.getUtf8Reader("can.csv"), Code.class);
        result.forEach(code -> {
            if (code.getLevel() == 2) {
                code.setPath("10798," + code.getId());
            }
            if (code.getLevel() == 3) {
                code.setPath("10798," + code.getPid() + "," + code.getId());
            }
        });

        CsvWriter writer = CsvUtil.getWriter("can-real.csv", CharsetUtil.CHARSET_UTF_8);
        result.forEach(code -> {
            String[] data = new String[7];
            data[0] = String.valueOf(code.getId());
            data[1] = String.valueOf(code.getPid());
            data[2] = code.getPath();
            data[3] = String.valueOf(code.getLevel());
            data[4] = code.getName();
            data[5] = code.getNameEn();
            data[6] = code.getCode();
            writer.write(data);
        });
    }
}
