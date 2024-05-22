package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new EdgeDriver();

        driver.get("https://developer.microsoft.com/");

        Thread.sleep(2000);

        driver.quit();

    }
}