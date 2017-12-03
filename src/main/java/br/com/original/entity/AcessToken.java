package br.com.original.entity;

/**
 * Created by @cardosomarcos on 02/12/17
 */
public class AcessToken {
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "AcessToken{" +
                "access_token='" + access_token + '\'' +
                '}';
    }
}
