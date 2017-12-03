package br.com.original.service;

/**
 * Created by @cardosomarcos on 02/12/17
 */

import br.com.original.config.Constants;
import br.com.original.config.OriginalAuth;
import br.com.original.entity.AcessToken;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Filter all request original api's
 */
@Service
public class OriginalService {

    @Autowired
    OriginalAuth originalAuth;

    public Object methodGetOriginal(String path, String token) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Constants.DOMAIN + path)
                .get()
                .addHeader("developer-key", Constants.DEVELOPERKEY)
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        return parseJson(response.body().string());
    }

    public Object parseJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Object.class);
    }
}
