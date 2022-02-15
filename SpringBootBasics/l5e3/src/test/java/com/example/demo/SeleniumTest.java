package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080/animal");
        WebElement animalInput;
        WebElement adjectiveInput;


        int counter = 0;
        List<WebElement> trainingResults = webDriver.findElements(By.className("trainingMessage"));
        for (int i = 0; i < 5; i++) {

            animalInput = webDriver.findElement(By.id("animalText"));
            adjectiveInput = webDriver.findElement(By.id("adjective"));

            animalInput.clear();
            adjectiveInput.clear();

            animalInput.sendKeys("Animal" + counter);
            adjectiveInput.sendKeys("Adjective" + counter);

            adjectiveInput.submit();

            counter ++;

            Thread.sleep(2000);
            System.out.println("trainingResults.size() = " + trainingResults.size());
        }

        WebElement conclusionResult = webDriver.findElement(By.className("conclusionMessage"));
        System.out.println("conclusionResult.getText() = " + conclusionResult.getText());

        Thread.sleep(5000);
        webDriver.quit();
    }
}

//        WebElement animalInput = webDriver.findElement(By.id("animalText"));
//        animalInput.sendKeys("Animal" + counter);
//
//        WebElement adjectiveInput = webDriver.findElement(By.id("adjective"));
//        adjectiveInput.sendKeys("Adjective" + counter);

