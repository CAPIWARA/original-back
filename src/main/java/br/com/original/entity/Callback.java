package br.com.original.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Entity
public class Callback {
    @Id
    private int callback_id;
    @Column(columnDefinition = "TEXT")
    private String auth_code;
    private String euid;
    @Column(columnDefinition = "TEXT")
    private String bearer;
    private String name;
    private String conta;

    public Callback(String callback_id, String auth_code, String euid) {
        this.callback_id = Integer.parseInt(callback_id.replaceAll("\\D", ""));
        this.auth_code = auth_code.replaceAll("auth_code=", "");
        this.euid = euid.replaceAll("uid=", "");
    }

    public Callback() {
    }

    public int getCallback_id() {
        return callback_id;
    }

    public void setCallback_id(int callback_id) {
        this.callback_id = callback_id;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getEuid() {
        return euid;
    }

    public void setEuid(String euid) {
        this.euid = euid;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
