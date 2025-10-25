package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility
{
	public static String getValueInPropertiesFile(String propertyname) throws Exception
	{
		//In one project, we will get one "config.properties" file only
		//Take path of properties file
		String pfpath="src\\test\\resources\\sources\\config.properties";
		//Take read permission on that file
		FileInputStream fi=new FileInputStream(pfpath);
		//Parse that file content as property name and value pairs
		Properties p=new Properties();
		p.load(fi);
		//Take value of given property name
		try
		{
			String value=p.getProperty(propertyname);
			fi.close();
			//Return that value
			return(value);
		}
		catch(Exception ex)
		{
			fi.close();
			return(null);
		}
	}
}








