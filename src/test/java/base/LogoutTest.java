package base;

import base.BaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test (description = "Authorization and logout")
    public void logout (){
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .logOut();
    }
}
