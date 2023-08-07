package chaitraVtiger;

import vTiger.GenericUtilities.JavaUtility;

public class GenericUtilityRandom {

	public static void main(String[] args) {
		
     JavaUtility ju=new JavaUtility();
     int number = ju.getRandomNumber();
     System.out.println(number);
	}

}
