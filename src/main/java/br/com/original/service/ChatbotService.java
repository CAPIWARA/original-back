package br.com.original.service;

import br.com.original.config.Constants;
import br.com.original.entity.Chat;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by @cardosomarcos on 03/12/17
 */

@Service
public class ChatbotService {


    public String getUrlaudio(String text) throws IOException {
        return Constants.CHAT_URL + "/speech?text=" + text;
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

    public String getChat(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constants.CHAT_URL + "/chat?text=" + text)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        LinkedTreeMap map = (LinkedTreeMap) parseJson(response.body().string());
        String[] lista = map.get("output").toString().split(",");
        return lista[0].replace("{text=[", "").replace("]","");
    }

}
