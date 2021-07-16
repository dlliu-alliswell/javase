package dl.alliswell.javase.base.http;

import dl.alliswell.javase.base.Contants;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author: dlliu
 * @date_time: 2021/6/30 9:45
 * @description:
 */
public class HttpsProxyOfHttpClient {
    public static void main(String[] args) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getCredentialsProvider().setCredentials(new AuthScope(Contants.PROXY_IP, Contants.PROXY_PORT),
                new UsernamePasswordCredentials(Contants.USER_NAME, Contants.PASSWORD));
        HttpHost targetHost = new HttpHost("update1.hillstonenet.com", 443, "https");
        HttpHost proxy = new HttpHost(Contants.PROXY_IP, Contants.PROXY_PORT);
        httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

        HttpGet httpGet = new HttpGet("/cgi-bin/app_update_sig.cgi?magic=df04f1fc0680a844dc9a8e5459cc1c211551&vendor=1&module=app&app_ver=1&SN=123456789&version=3.0.210519");
        HttpResponse response = httpClient.execute(targetHost, httpGet);
        InputStream inputStream = response.getEntity().getContent();
        FileOutputStream fs = new FileOutputStream("D:/test.txt");
        byte[] buf = new byte[1024*1024*10];
        int byteread = 0;
        while ((byteread = inputStream.read(buf)) != -1) {
            fs.write(buf, 0, byteread);
        }
        System.out.println(response);
    }

    private static void test1() throws IOException {
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        String headerKey = "proxy-Authorization";
        String headerValue = "Basic " + Base64.getEncoder().encodeToString((Contants.USER_NAME + ":" + Contants.PASSWORD).getBytes(StandardCharsets.UTF_8));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpHost proxy = new HttpHost(Contants.PROXY_IP, Contants.PROXY_PORT, "http");
        RequestConfig config =
                RequestConfig.custom().setProxy(proxy).build();
        HttpGet httpGet = new HttpGet("https://10.182.142.181/");
        httpGet.setConfig(config);
        httpGet.setHeader(headerKey, headerValue);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(response);
    }
}
