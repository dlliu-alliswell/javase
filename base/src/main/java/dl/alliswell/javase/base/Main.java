package dl.alliswell.javase.base;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author: dlliu
 * @date_time: 2020/8/13 9:45
 * @description:
 */
public class Main {
    private static final String PROXY_IP = "10.182.134.61";
    private static final String PROXY_PORT = "1025";

    private static final String USER_NAME = "ttpan1";
    private static final String PASSWORD = "hillstone";

    public static void main(String[] args) throws IOException {
        /*System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        System.out.println(System.getProperty("jdk.http.auth.tunneling.disabledSchemes"));
        InetSocketAddress address = new InetSocketAddress(PROXY_IP, Integer.parseInt(PROXY_PORT));

        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
        URL url = new URL("https://10.182.142.181/");
        URLConnection connection = null;

        connection = url.openConnection(proxy);
        

        String headerKey = "proxy-Authorization";
        String headerValue = "Basic " + Base64.getEncoder().encodeToString((USER_NAME + ":" + PASSWORD).getBytes(StandardCharsets.UTF_8));
        System.out.println(headerValue);
        connection.setRequestProperty(headerKey, headerValue);


        System.out.println(connection.getRequestProperties());
        InputStream inputStream = connection.getInputStream();
        System.out.println(inputStream);*/
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpHost target = new HttpHost("10.182.142.181", 443, "https");
        HttpHost proxy = new HttpHost("10.182.134.61", 1025, "http");
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        HttpGet httpGet = new HttpGet("/");
        httpGet.setConfig(config);
        String headerKey = "proxy-Authorization";
        String headerValue = "Basic " + Base64.getEncoder().encodeToString((USER_NAME + ":" + PASSWORD).getBytes(StandardCharsets.UTF_8));
        httpGet.addHeader(headerKey, headerValue);
        CloseableHttpResponse response = httpclient.execute(target, httpGet);
        System.out.println(response);
    }
}
