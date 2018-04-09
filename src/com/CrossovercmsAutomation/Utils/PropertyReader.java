package com.CrossovercmsAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
/*
 * Properties files to read the config. properties values.
 * Based on key value pair.
 */

public class PropertyReader {
	Properties props = new Properties();
	String strFileName;
	String strValue;
	public PropertyReader(String strFileName) 
	{
		this.strFileName = strFileName;
	}

	public String getProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strValue = props.getProperty(strKey);
				in.close();
			} else
				System.out.println("File not found!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return strValue;
	}
	public void setProperty(String strKey, String strValue) throws Throwable {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.setProperty(strKey, strValue);
				props.store(new FileOutputStream(strFileName), null);
				in.close();
			} else {
				System.out.println("File not found!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}



}
