package com.webapp.microservice.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class SeleniumTest {
  /*
  private static WebDriver driver;
  private static Map<String, Object> vars;
  static JavascriptExecutor js;

  By evaluatorPageLocator = By.id("postulantes");
  By evaluatorBtnLocator = By.cssSelector("button[id='0']");

  @BeforeAll
  public static void setUp(){
    System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    driver = new ChromeDriver(chromeOptions);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  void testEvaluator(){
    driver.get("http://143.110.148.226:3000/evaluar");
    if(driver.findElement(evaluatorPageLocator).isDisplayed()){
      try{
        Thread.sleep(3000);
      }catch (Exception e){
        System.out.println(e.getMessage());
      }
      driver.findElement(evaluatorBtnLocator).click();
      try{
        Thread.sleep(3000);
      }catch (Exception e){
        System.out.println(e.getMessage());
      }
    }
    else {
      System.out.println("La página de evaluador no se encontró");
    }
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

   */
}
