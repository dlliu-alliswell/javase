package dl.alliswell.javase.base.json;

import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: dlliu
 * @date_time: 2020/9/7 9:19
 * @description:
 */
public class PaserJson {
    public static void main(String[] args) {
        CsvWriter writer = CsvUtil.getWriter("can.csv", CharsetUtil.CHARSET_UTF_8);
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(classpath);
        String filePath = classpath + "can/";
        System.out.println(filePath);
        File canDirfile = new File(filePath);
        File[] files = canDirfile.listFiles();
        for (File file: files) {
            List<Map<String, String>> codeList = new ArrayList<>();
            JSONObject json = JSONUtil.readJSONObject(file, StandardCharsets.UTF_8);
            JSONArray jsonArray = (JSONArray) json.get("features");
            JSONObject[] codeJsons = jsonArray.toArray(new JSONObject[]{});
            for (JSONObject codeJson: codeJsons) {
                Map<String, String> map = new HashMap<>();
                map.put("name", (String) ((JSONObject) codeJson.get("properties")).get("name"));
                map.put("code",String.valueOf(((JSONObject) codeJson.get("properties")).get("code")));
                codeList.add(map);
            }
            System.out.println(codeList.toString());

            for (Map<String, String> code:
                    codeList) {
                String[] codeLine = new String[2];
                codeLine[0] = code.get("name");
                codeLine[1] = code.get("code");
                writer.write(codeLine);
            }
        }
    }
}
