package org.example;

import org.example.framework.DriverFactory;
import org.example.pages.ExamplePage;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.equalTo;

class ExamplePageTest {
    private WebDriver driver;
    private ExamplePage examplePage;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createChromeDriver();
        examplePage = new ExamplePage(driver);
    }

    @Test
    void shouldDisplayExampleDomainHeading() {
        examplePage.open();

        MatcherAssert.assertThat(examplePage.getHeading(), equalTo("Example Test Application"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
