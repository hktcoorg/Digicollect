package com.digicollect.Genric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is contains reusable methods of property file
 * @author THRINESH
 *
 */
public class FileUtility {
	private FileInputStream fis;
	private Properties property;
	
	/**
	 * After creation of object call this method to initialize property file
	 * @param propertyFilePath
	 * @throws IOException
	 */
	public void openPropertyFile(String propertyFilePath) throws IOException
	{
		fis=new FileInputStream(propertyFilePath);
		property=new Properties();
		property.load(fis);
	}
	/**
	 * This method is used to fetch data from property file
	 * Specify propertyFilePath from IconstantPath interface
	 * Specify Key value from Enum PropertyFileKey
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		String value = property.getProperty(key).trim();  //trim is used to remove space from property file value
		return value;
	}
	
	/**
	 * This method is used to close the property file
	 * @throws IOException
	 */
	public void closePropertyFile() throws IOException
	{
		fis.close();
	}
}


