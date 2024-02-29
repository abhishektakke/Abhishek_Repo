package com.jbk.uttilites;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;

public class ReadConfig 
{
	Properties properties ;
	
	public ReadConfig()
	{
		 properties = new Properties();
		try 
		{
			properties.load(new FileInputStream("./Configration/config.properties"));
			PropertyConfigurator.configure(properties);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getProperty(String text)
	{
		String Property =properties.getProperty(text);
		return Property;
	}
}
