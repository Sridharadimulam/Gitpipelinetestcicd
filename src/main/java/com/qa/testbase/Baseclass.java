package com.qa.testbase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.Utils.Getscreensottest;

public class Baseclass {
	Logger log=Logger.getLogger(Baseclass.class.getSimpleName());
	public static WebDriver dr;
    public static SimpleDateFormat far;
    public static Calendar cal;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;
    public static ExtentTest test;
   @BeforeMethod
    public void bmethos(Method method){
    	log.info(method.getName()+": method is started");}
    @BeforeTest
    public void loadlog4j(){
    	cal=Calendar.getInstance();
    	 far=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	System.out.println(far.format(cal.getTime()).toString());
    String log4jconfigpath=System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Log4J.properties";
    PropertyConfigurator.configure(log4jconfigpath);
    log.info("started");
    htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/GriceReport_"+far.format(cal.getTime())+".html");
    report = new ExtentReports();
    report.attachReporter(htmlReporter);
    htmlReporter.config().setDocumentTitle("Techwave.net Reports");
    htmlReporter.config().setReportName("Grice App Report");
    htmlReporter.config().setTheme(Theme.DARK);
    }
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    { 
    	if(result.getStatus() == ITestResult.FAILURE)
          {       test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
                test.fail(result.getThrowable());
        
        }
          else if(result.getStatus() == ITestResult.SUCCESS)
          {
                test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN)); }
          else{
                test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
                test.skip(result.getThrowable());
          }   
    
    }
    
    public static Object screencapture(String logdetails ,String imagepath) throws IOException{
    	test.log(Status.INFO,logdetails,MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
    	return test;
    }
    
    
  public void passorfailscreenshot(String screenShotName) throws IOException{
String screenshot=Getscreensottest.capture(screenShotName);
screencapture("test", screenshot);
  }
    }

