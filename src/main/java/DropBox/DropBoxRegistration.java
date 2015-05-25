package DropBox;


import DropBox.PageFactory.FillFormDropBoxRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by svetlana on 15.04.15.
 */
public class DropBoxRegistration {
    WebDriver driver;
    FillFormDropBoxRegistration DropBoxRegistration;
    private static final String PASSWORD = "1q2w3e4r5t6y";

    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://db.tt/MZbK5JNQ");
        DropBoxRegistration = new FillFormDropBoxRegistration(driver);
    }

    public void userRegistration() {
        String uniqueString;
        uniqueString = createUniqueString();
        String emailAddress = uniqueString + "@" + "mail.ru";
        DropBoxRegistration.fillFormRegistration(uniqueString, uniqueString, emailAddress, PASSWORD);

        saveEmailToFile(emailAddress, PASSWORD);
        System.out.println(emailAddress + " " + PASSWORD);
    }

    private String createUniqueString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int r = (int) (Math.random() * 25) + 65;
            sb.append(Character.toChars(r)[0]);
        }
        return sb.toString();
    }

    private void saveEmailToFile(String emailAddress, String password) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true))) {

            bufferedWriter.write(emailAddress);
            bufferedWriter.newLine();
            bufferedWriter.write(password);
            bufferedWriter.newLine();
            bufferedWriter.newLine();

        } catch (FileNotFoundException exception) {
            System.out.println("File is not available for write");
            exception.printStackTrace();
        } catch (IOException exception) {
            System.out.println("there is a error while writing to the file");
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void captchaAppears() {

        WebElement captcha = driver.findElement(By.cssSelector("input[type=text]"));
        if(null != captcha){
            System.err.println("Captcha appears");
            try {
                tearDown();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }


    }

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
