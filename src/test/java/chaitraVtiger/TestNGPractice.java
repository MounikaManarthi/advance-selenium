package chaitraVtiger;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

/*	
	@Test(priority=2)
public void createCustomer()
{
System.out.println("customer created");	
}

@Test(invocationCount =3)
public void modifyCustomer()
{
	Assert.fail();
System.out.println("customer modified");	
}

@Test(priority=-1)
public void deleteCustomer()
{
System.out.println("customer deleted");	
}

@Test(enabled=false)
public void restoreCustomer()
{
	System.out.println("customer restored");*/	


	@Test
public void createCustomer()
{
		Assert.fail();
System.out.println("customer created");	
}

@Test(dependsOnMethods  ="createCustomer")
public void modifyCustomer()
{
System.out.println("customer modified");	
}

@Test
public void deleteCustomer()
{
System.out.println("customer deleted");	
}

@Test(dependsOnMethods  = {"createCustomer","modifyCustomer"})
public void restoreCustomer()
{
	System.out.println("customer restored");
}
}
