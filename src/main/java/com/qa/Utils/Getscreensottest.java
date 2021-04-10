package com.qa.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.testbase.Baseclass;

public class Getscreensottest extends Baseclass{
	
	 public static String capture(String screenShotName) throws IOException
	    {	
	        TakesScreenshot ts = (TakesScreenshot)dr;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	     String destpath = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+far.format(cal.getTime())+".png";
	        File destination = new File(destpath);
	        try{
	        FileUtils.copyFile(source, destination);   }
	        catch(IOException e){
	        	System.out.println("captured Failed "+e.getMessage());
	        }
	        return destpath;
	    }
}
