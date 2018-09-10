/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azercell.framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 *
 * @author Mensur Owary
 */
public class PageTest {

    protected WebDriver webdriver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) {
        switch (browser.toLowerCase()) {
            case "phantom":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\MansurGulami\\Desktop\\Data\\chromedriver.exe");
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--headless");
                this.webdriver = new ChromeDriver(co);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\MansurGulami\\Desktop\\Data\\chromedriver.exe");
                this.webdriver = new ChromeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "C:\\Users\\MansurGulami\\Desktop\\Data\\IEDriverServer.exe");
                this.webdriver = new InternetExplorerDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\MansurGulami\\Desktop\\Data\\chromedriver.exe");
                this.webdriver = new ChromeDriver();
                break;
        }
    }

    @AfterClass
    public void destruct() {
        this.webdriver.manage().deleteAllCookies();
        this.webdriver.quit();
    }

}
