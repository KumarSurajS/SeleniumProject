package example;

import BasePage.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listerners extends Base implements ITestListener {


    public Listerners() throws IOException {
    }

    @Override
    public void onTestStart(ITestResult result){

    }

    @Override
    public void onTestSuccess(ITestResult result){

    }

    @Override
    public void onTestFailure(ITestResult result) {
       String methodName = result.getMethod().getMethodName();
        try {
            failed(methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

    }

    @Override
    public void onStart(ITestContext context){

    }

    @Override
    public void onFinish(ITestContext context){

    }


}
