package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provide implementation to ITestListener Interface of TestNG.
 * @author Ultimate
 *this is an examples for abstraction
 */
public class ListenerImplementationClass implements ITestListener {
//to implement methods--rightclick-source-override/implements method-choose itestlistener
	ExtentReports ExtRep;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
     		               //ITestResult-its an interface.it capture result and store status in result variable
		String methodName = result.getMethod().getMethodName();
		System.out.println("================= Execution Started ======================"+methodName);
		
		test=ExtRep.createTest(methodName);//to intimate test is started
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName 	=result.getMethod().getMethodName();
		//System.out.println(methodName+" PASSED");
		
		test.log(Status.PASS, methodName+" PASSED");
	}

	public void onTestFailure(ITestResult result) {
		String methodName 	=result.getMethod().getMethodName();
		//System.out.println(methodName+" FAILED");
		
		test.log(Status.FAIL, methodName+" FAILED");
		
		//System.out.println(result.getThrowable());//it will print the exception that was occured
		
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wu=new WebDriverUtility();//for taking screenshot
		JavaUtility ju=new JavaUtility();//for date format
		
		String screenshotName=methodName+ju.getSystemDateInFormat();
		
		/*Take screen shots for failed test scripts -to attach with bug rising*/
		try {
			
			String path = wu.takeScreeShot(BaseClass.sdriver, screenshotName);
			                               //calling web driver using baseclass.static variable
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName 	=result.getMethod().getMethodName();
		//System.out.println(methodName+" SKIPPED");	
		
		test.log(Status.SKIP, methodName+" SKIPPED");
		
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
//by using log it will print in report
		//sysout it will print in console only
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	//start of <suite>	 -@BeforeSuite	
		
	System.out.println("=================== suite execution started=====================");
	
	//configure the extent report
	ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\Extentreport\\Report- "+new JavaUtility().getSystemDateInFormat()+".html");
	htmlReport.config().setDocumentTitle("Vtiger Execution report");
	htmlReport.config().setReportName("Build 3 vTiger execution Report");
	htmlReport.config().setTheme(Theme.DARK);
	
	//Report Generation
	ExtentReports ExtRep=new ExtentReports();
	ExtRep.attachReporter(htmlReport);
	ExtRep.setSystemInfo("Base Browser", "chrome");
	ExtRep.setSystemInfo("Base PlatForm", "Testing-Env");
	ExtRep.setSystemInfo("Base URL", "http://localhost:8888");
	ExtRep.setSystemInfo("Base OS", "windows");
	ExtRep.setSystemInfo("Reporter", "chaitra");

	}

	public void onFinish(ITestContext context) {
		//end of <suite>	 -@AfterSuite	
		System.out.println("=================== suite execution ended=====================");

		//report generation
		ExtRep.flush();
	}
	
}
