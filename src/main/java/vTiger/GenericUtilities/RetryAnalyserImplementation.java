package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=1;
	int retryCount=3;                //pass/fail
	public boolean retry(ITestResult result) {
		      //1<=3. 2<=3,3<=3,4<=3 here count fail then come out of the loop stops the execution
		while(count<=retryCount)
		{
			count++;//2 3 4
			return true;//retry retry retry
		}
		return false;//dont retry
	}

}
