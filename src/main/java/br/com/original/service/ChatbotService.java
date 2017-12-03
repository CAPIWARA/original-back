package br.com.original.service;

import br.com.original.config.Constants;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by @cardosomarcos on 03/12/17
 */

@Service
public class ChatbotService {


    public Request getUrlaudio(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constants.CHAT_URL + "/speech?text=" + text)
                .get()
                .build();
        return request;
    }

    public Object parseJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Object.class);
    }

    public String getCubinhos(String id) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constants.CHAT_URL + "/cubinhos?text=" + id)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
