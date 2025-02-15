import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class seleniumtest {
    @Test
    public void testvalidlogin() throws Exception {
        System.setProperty("webdriver.Edge.driver","C:\\Users\\user\\Desktop\\edgedriver_win32\\msedgedriver.exe");
        WebDriver webDriver = new EdgeDriver();

        webDriver.navigate().to("https://www.instagram.com/?hl=en");
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("roaa_aymann");
        webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("1234");
        webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
        Thread.sleep(10000);
        String expectedURL = "https://www.instagram.com/accounts/login/two_factor?hl=en&next=%2F";  // URL after successful login
        String actualURL = webDriver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
        Thread.sleep(2000);




    }
    @Test
    public void invalidLogin() throws InterruptedException {
        System.setProperty("webdriver.Edge.driver","C:\\Users\\user\\Desktop\\edgedriver_win32\\msedgedriver.exe");
        WebDriver webDriver = new EdgeDriver();

        webDriver.navigate().to("https://www.instagram.com/?hl=en");
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("roaa_aymann");
        webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("invalidpass");
        webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
        Thread.sleep(2000);
       String expected="Sorry, your password was incorrect. Please double-check your password.";
       String actual=webDriver.findElement(By.xpath("//*[@id=\"loginForm\"]/span/div")).getText();

        Thread.sleep(2000);


    }


}
