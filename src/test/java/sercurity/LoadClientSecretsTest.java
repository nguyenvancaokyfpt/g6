package sercurity;

import com.tss.helper.GoogleLoginHelper;
import com.tss.model.sercurity.GoogleClientSecret;

public class LoadClientSecretsTest {

    public static void main(String[] args) {
        GoogleClientSecret googleClientSecret = GoogleLoginHelper.loadClientSecrets();
        System.out.println(googleClientSecret);
    }
    
}
