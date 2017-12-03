package br.com.original.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Component
public class Constants {

    public static String DEVELOPERKEY;
    public static String SECRETKEY;
    public static String AUTH_DOMAIN = "https://sb-autenticacao-api.original.com.br/";
    public static String DOMAIN = "https://sandbox.original.com.br";
    public static String CHAT_URL = "https://chatoriginal.mybluemix.net";

    @Value("${enviroments.developerkey}")
    private void setDEVELOPERKEY(String string) {
        DEVELOPERKEY = string;
    }

    @Value("${enviroments.secretkey}")
    private void setSECRETKEY(String string) {
        SECRETKEY = string;
    }
}