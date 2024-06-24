package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidLogincredentials")
	public Object userCredentialsdata()
	{
		Object data[][]= new Object[3][2];
		data[0][0]="admin";		
		data[0][1]="1231";		
		data[1][0]="adminstr";		
		data[1][1]="123456";		
		data[2][0]="administr";		
		data[2][1]="12347";
		
		
		return data;
	}


}
