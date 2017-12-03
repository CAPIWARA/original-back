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

    @Value("${enviroments.developerkey}")
    private void setDEVELOPERKEY(String string) {
        DEVELOPERKEY = string;
    }

    @Value("${enviroments.secretkey}")
    private void setSECRETKEY(String string) {
        SECRETKEY = string;
    }
}