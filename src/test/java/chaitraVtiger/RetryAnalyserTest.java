package chaitraVtiger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class RetryAnalyserTest {

	
	
	               //copy qualified name of retryanalyser class from generic utilities 
	@Test(retryAnalyzer=vTiger.GenericUtilities.RetryAnalyserImplementation.class)
public void sample()
{
		Assert.fail();//when fail then it will retry executing the script for 3 times
System.out.println("hello");	
}
}
