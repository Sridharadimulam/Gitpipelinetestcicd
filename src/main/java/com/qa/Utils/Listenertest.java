package com.qa.Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.testbase.Baseclass;

public class Listenertest extends Baseclass implements ITestListener {
	private static final Logger log=Logger.getLogger(Listenertest.class);
	public WebDriver dr;
	public void onTestStart(ITestResult result) {
		try{
			
			test=report.createTest(	result.getName()+" is started");

			result.getName();
		}catch(Exception e){
			e.printStackTrace();
			result.getName();}}
	public void onTestSuccess(ITestResult result) {
		try{
			test=report.createTest(	result.getName()+" is passed");
			result.getName();
		}catch(Exception e){
			e.printStackTrace();}}
	
	public void onTestFailure(ITestResult result) {	
		try{  	

			Getscreensottest.capture(result.getName());
		  passorfailscreenshot(result.getName());
	test=report.createTest(	result.getName()+" is failed");
	}catch(Exception e){
		e.printStackTrace();
		test=report.createTest(result.getName()+"is failed"+e.getCause());
		}
		}
	public void onTestSkipped(ITestResult result) {
		try{
			result.getName();
		}catch(Exception e){
			e.printStackTrace();}}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			result.getName();}
	public void onStart(ITestContext context) {
			context.getName();}
	public void onFinish(ITestContext context) {
		  try {
			 log.info(context.getName()+":is finish");
	          report.flush();
	          System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	          dr=new ChromeDriver();
	          dr.manage().window().maximize();
	          dr.get(System.getProperty("user.dir") +"/Reports/GriceReport_"+far.format(cal.getTime())+".html");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();}}}
