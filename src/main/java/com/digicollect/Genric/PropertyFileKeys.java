package com.digicollect.Genric;
/**
 * This enum include keys of property file
 * @author THRINESH
 *
 */
public enum PropertyFileKeys {
	
	/**
	 * all values convert to string. when using these method use converttoSting method also
	 */
	
	BROWSER("browser"),TIMEOUT("timeout"), URL("url"), ADMINUSERNAME("adminusername"),ADMINPASSWORD("adminpassword"),USERNAME("userusername"),USERNAMEPASSWORD("userpassword"), PACKAGENAME("packagename"),
	DBURL("dburl"), DBPASSWORD("dbpassword"), DBUSERNAME("dburl"), CURRENTPASSWORD("currentPassword"), NEWPASSWORD("newpassword"), CONFIRMPASSWORD("confirmpassword"), URLFLIP("urlflip"),
	DIGIURL("digiurl");
	
	private String keys;
	/**
	 * setter
	 * @param keys
	 */
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;
	}
	
	/**
	 * getter
	 * @return
	 */
	public String converttoString()
	{
		return keys.toString();
	}
}
