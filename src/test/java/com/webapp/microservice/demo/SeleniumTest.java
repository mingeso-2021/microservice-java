package com.webapp.microservice.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;

public class SeleniumTest {

  private static WebDriver driver;
  private static Map<String, Object> vars;
  static JavascriptExecutor js;

  //By evaluatorLinkLocator = By.cssSelector("a[name='Evaluate']");
  By evaluatorPageLocator = By.id("postulantes");
  By evaluatorBtnLocator = By.cssSelector("button[id='0']");

  @BeforeAll
  public static void setUp() throws Exception{
    System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    //driver.get("http://143.110.148.226:3000/evaluar");
  }

  /*
  @Test
  public void testPostulations() {
    // make a "click" in "Postular" on the navbar
    //driver.findElement(postulateLinkLocator).click();

    (new File("C:\\Downloads\\image.png"))

    if(driver.findElement(postulatePageLocator).isDisplayed()){
      driver.findElement(dragzoneLocator).sendKeys("Francisco/2.pdf");
      driver.findElement(submitBtnLocator).click();
    }
    else {
      System.out.println("La página de postulante no se encontró");
    }
  }
 */
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
    //driver.quit();
  }
}
