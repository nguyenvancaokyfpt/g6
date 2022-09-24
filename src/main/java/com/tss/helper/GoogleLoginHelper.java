package com.tss.helper;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Properties;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.tss.model.User;
import com.tss.model.sercurity.GoogleClientSecret;

public class GoogleLoginHelper {
    
    public static GoogleClientSecret loadClientSecrets() {
        Properties properties = new Properties();
        InputStream is = GoogleLoginHelper.class.getClassLoader().getResourceAsStream("google_client_secret.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String client_id = properties.getProperty("client_id");
        String client_secret = properties.getProperty("client_secret");
        String auth_uri = properties.getProperty("auth_uri");
        String token_uri = properties.getProperty("token_uri");
        String redirect_uris = properties.getProperty("redirect_uris");
        return new GoogleClientSecret(client_id, client_secret, auth_uri, token_uri, redirect_uris);
    }
    

    public static User getUserInfo(String accessToken) throws IOException {
        GoogleClientSecret googleClientSecret = GoogleLoginHelper.loadClientSecrets();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
                .setAudience(Collections.singletonList(googleClientSecret.getClient_id())).build();
        try {
            GoogleIdToken idToken = verifier.verify(accessToken);
            if (idToken != null) {
                Payload payload = idToken.getPayload();
                User user = new User();
                user.setEmail(payload.getEmail());
                user.setFullname((String) payload.get("name"));
                user.setAvatarUrl((String) payload.get("picture"));
                return user;
            } else {
                return null;
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

}
