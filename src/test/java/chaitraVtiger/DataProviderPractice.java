package chaitraVtiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="phones")
	public void addToCartTest(String name,int price,String model)
	{
		System.out.println("phone name : "+name+ " price : "+price+" model : "+model);
		
	}
	
	
	@DataProvider(name="phones")
	public Object[][] getData()
	{
    Object[][] data=new Object[3][3];
                             //row cell
    data[0][0]="iphone";  //first set of data
    data[0][1]=20000;
    data[0][2]="s1d";

    data[1][0]="redme";    //second set of data
    data[1][1]=30000;
    data[1][2]="d23";

    data[2][0]="oneplus";     //third set of data
    data[2][1]=40000;
    data[2][2]="3e4r";
    
    return data;
	}
}
