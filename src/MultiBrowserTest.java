import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*
Project-3 - ProjectName : com-herokuapp
BaseUrl = http://the-internet.herokuapp.com/login
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Enter the email to email field.
7. Enter the password to password field.
8. Click on Login Button.
9. Print the current url.
10. Refresh the page.
11. Close the browser
 */

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = " http://the-internet.herokuapp.com/login";
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
        //1.set up multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2.open Url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //3.print title of page
        String title = driver.getTitle();
        System.out.println("Title of page:" + title);

        //4. print current url
        System.out.println(driver.getCurrentUrl());

        //5.print page source
        String pageSource = driver.getPageSource();
        System.out.println(driver.getPageSource());

        //6.Enter email to email field
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("david");

        //7.enter password to password field
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("British12");
        Thread.sleep(3000);

        //8.click on login button
        WebElement loginLink = driver.findElement(By.xpath("//button[@type='submit']"));
        loginLink.click();
        Thread.sleep(3000);

        //9.print current url
        System.out.println("The current url :" + driver.getCurrentUrl());

        //10.refresh page
        driver.navigate().refresh();

        //11.close browser
        driver.quit();


    }

}
