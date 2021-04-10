package Testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testbase.Baseclass;

public class sampletest extends Baseclass {
	private static final Logger log=Logger.getLogger(sampletest.class);
	
	
@Test(priority=0)
	public void te(){		
	test.assignCategory("sanity");	
	test.assignCategory("Regression");
		dr=new ChromeDriver();
		test.info("test te is started");
	 dr.get("https://sonnysdirect.com");
	 dr.manage().window().maximize();
	 log.info("browser launch sucess");
	 String title=dr.getTitle();
			 try{
	Assert.assertEquals(title, "Car Wash Equipment Supplier | Sonny’s The CarWash Factory");
	test.info("test te is passed");
	 log.info("test");
	 }	 catch(Exception e){
				 log.info("test errotr"); 
				 
			 }			 	
	}


@Test(priority=1)
	public void te1(){
	test.assignCategory("Regression");
		dr=new ChromeDriver();
		test.info("test te is started");
	 dr.get("https://sonnysdirect.com");
	 dr.manage().window().maximize();
	 log.info("browser launch sucess");
	 String title=dr.getTitle();
			 try{
	Assert.assertEquals(title, "Car Washh Equipment Supplier | Sonny’s The CarWash Factory");
	test.info("test te is passed");
	 log.info("test");
	 }
			 catch(Exception e){
				 log.info("test error"); 
				 
			 }
			 }



@Test(priority=2)
	public void te2(){
	test.assignCategory("Functional");
		dr=new ChromeDriver();
		test.info("test te is started");
		dr.get("http://google.com");
		 log.info("browser launch sucess");
		String s=dr.getTitle();
		
		 log.info("title is:"+s);
		log.info(sampletest.class.getSimpleName());
			if(s.equals("Car Wash Equipment Supplier | Sonny’s The CarWash Factory")){
				log.info(sampletest.class.getSimpleName()+"title is matched");
				Assert.assertEquals(s, "Car Wash Equipment Supplier | Sonny’s The CarWash Factory");
				test.info("test te is passed");
		}else{	
		log.error(sampletest.class.getSimpleName()+"title is not matched");
		 
	}
 dr.quit();
}
	
}
