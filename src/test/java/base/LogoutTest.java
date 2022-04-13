package base;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {


    @Severity(SeverityLevel.CRITICAL)
    @Description("Authorization and logout")
    @Test
    public void logout (){
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .logOut();
    }
}
