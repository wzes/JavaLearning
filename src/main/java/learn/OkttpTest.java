package learn;

import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Create by xuantang
 * @date on 8/22/18
 */
public class OkttpTest {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .build();

        String url = "https://www.ifeng.com/";
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Extractor extractor = new Extractor();
                String content = response.body().string();
                List<Url> allLinks = extractor.getAllLinks(url, content);
                Url text = extractor.getText(url, content);
                System.out.println(text.getContent());
                allLinks.stream().forEach(u -> System.out.println(u.getName()));
            }
        });
    }
}
