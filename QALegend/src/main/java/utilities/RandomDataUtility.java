package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	static Faker faker;
	public static String getPrefix()
	{
		faker=new Faker();
		String prefix=faker.name().prefix();
		return prefix;
		
	}
	public static String getFirstName()
	{
		faker=new Faker();
		String firstname=faker.name().firstName();
		return firstname;
	}
	public static String getLastName()
	{
		faker=new Faker();
		String lastname=faker.name().lastName();
		return lastname;
		
	}

}
