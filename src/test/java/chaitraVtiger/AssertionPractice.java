package chaitraVtiger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
@Test
public void samplTest()
{
int a=1;  //exp
int b=2;   //actual

System.out.println("step 1");
System.out.println("step 2");
Assert.assertEquals(b, a);
System.out.println("step 3");
System.out.println("step 4");
System.out.println("execution and validation complete");

}
@Test
public void sampleTest1()
{
int a=1;  //exp
int b=2;   //actual

SoftAssert sa=new SoftAssert();

System.out.println("step 1");
System.out.println("step 2");
sa.assertEquals(false, true);  //fail
System.out.println("step 3");
System.out.println("step 4");
sa.assertTrue(false);   //fail
System.out.println("execution and validation complete");
sa.assertAll();

}
}
