package com.imdb.configurations;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Author: Dhruv Vinayak
 *
 * This class is used to take screenshot in case of test failure.
 * Here, apply() method of MethodRule is overwritten which intervene before Junit
 * sends out the test results and insert the screenshot capturing code.
 * 
 */

public class ScreenShotOnFailure implements MethodRule{
	private WebDriver driver;

    public ScreenShotOnFailure(WebDriver driver){
        this.driver = driver;
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    // exception will be thrown only when a test fails.
                    captureScreenShot(frameworkMethod.getName());
                    // re-throw to allow the failure to be reported by JUnit
                    throw t;
                }
            }

            public void captureScreenShot(String fileName) throws IOException {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                fileName += UUID.randomUUID().toString();
                File targetFile = new File("target\\screenshot\\" + fileName + ".png");
                FileUtils.copyFile(scrFile, targetFile);
            }
        };
    }
}
