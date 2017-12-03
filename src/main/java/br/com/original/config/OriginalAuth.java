package br.com.original.config;

import br.com.original.entity.AcessToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Service
public class OriginalAuth {

    public static String domain = "https://sb-autenticacao-api.original.com.br/";
    public String auth = null;
    private static final MediaType MediaTypeJSON = MediaType
            .parse("application/json; charset=utf-8");

    @PostConstruct
    public void getAuth(Integer id) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(domain + "OriginalConnect/?scopes=account,investiment&callback_url=http://localhost:8080/myapp&callback_id="+id+"&developer_key=" + Constants.DEVELOPERKEY)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("VALOR DA RESPOSTA: " + response);
    }

    public String generateToken(String uid, String auth_code, String developer_key, String secret_key) throws Exception {
        String url = domain + "OriginalConnect/AccessTokenController";
        OkHttpClient httpclient = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap<String, String> auth = new LinkedHashMap<>();
        auth.put("uid", uid);
        auth.put("auth_code", auth_code);
        auth.put("developer_key", developer_key);
        auth.put("secret_key", secret_key);
        String jsonAuth = mapper.writeValueAsString(auth);
        System.out.println("JSON: " + jsonAuth.toString());
        Request request = new Request.Builder().url(url)
                .post(RequestBody.create(MediaTypeJSON, jsonAuth)).build();
        Response response = httpclient.newCall(request).execute();
        Gson gson = new Gson();
        AcessToken object = gson.fromJson(response.body().string(), AcessToken.class);
        System.out.println(object.getAccess_token());
        return object.getAccess_token();
    }

    public String getToken(String uid, String auth_id) throws Exception {
        if (auth == null) return generateToken(uid, auth_id, Constants.DEVELOPERKEY, Constants.SECRETKEY);
        return auth;
    }
}
