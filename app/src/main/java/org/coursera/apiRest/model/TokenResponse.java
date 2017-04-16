package org.coursera.apiRest.model;

/**
 * Created by TouxStudio on 15/04/2017.
 */

public class TokenResponse {

    private String id;
    private String token;
    private String instagram_id;

    public TokenResponse(String id, String token, String instagram_id) {
        this.id = id;
        this.token = token;
        this.instagram_id = instagram_id;
    }

    public TokenResponse(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public TokenResponse() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getInstagram_id() {
        return instagram_id;
    }

    public void setInstagram_id(String instagram_id) {
        this.instagram_id = instagram_id;
    }

}
