package com.tss.model.sercurity;

import com.alibaba.fastjson.JSONArray;

public class GoogleClientSecret {

private String client_id;
    private String client_secret;
    private String auth_uri;
    private String token_uri;
    private String redirect_uris;

    public GoogleClientSecret() {
    }

    public GoogleClientSecret(String client_id, String client_secret, String auth_uri, String token_uri, String redirect_uris) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.auth_uri = auth_uri;
        this.token_uri = token_uri;
        this.redirect_uris = redirect_uris;
    }

    /**
     * @return String return the client_id
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * @param client_id the client_id to set
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * @return String return the client_secret
     */
    public String getClient_secret() {
        return client_secret;
    }

    /**
     * @param client_secret the client_secret to set
     */
    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    /**
     * @return String return the auth_uri
     */
    public String getAuth_uri() {
        return auth_uri;
    }

    /**
     * @param auth_uri the auth_uri to set
     */
    public void setAuth_uri(String auth_uri) {
        this.auth_uri = auth_uri;
    }

    /**
     * @return String return the token_uri
     */
    public String getToken_uri() {
        return token_uri;
    }

    /**
     * @param token_uri the token_uri to set
     */
    public void setToken_uri(String token_uri) {
        this.token_uri = token_uri;
    }

    /**
     * @return String return the redirect_uris
     */
    public String getRedirect_uris() {
        return redirect_uris;
    }

    /**
     * @param redirect_uris the redirect_uris to set
     */
    public void setRedirect_uris(String redirect_uris) {
        this.redirect_uris = redirect_uris;
    }

    @Override
    public String toString() {
        return JSONArray.toJSONString(this);
    }
    
    

}
