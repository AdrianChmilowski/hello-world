package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExamplePage extends BasePage {
    private static final By HEADING = By.tagName("h1");

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String baseUrl = System.getProperty("baseUrl");
        if (baseUrl == null || baseUrl.isBlank()) {
            var samplePage = getClass().getResource("/pages/example.html");
            if (samplePage == null) {
                throw new IllegalStateException("Sample page resource was not found.");
            }
            baseUrl = samplePage.toExternalForm();
        }
        driver.get(baseUrl);
    }

    public String getHeading() {
        return findVisible(HEADING).getText();
    }
}
