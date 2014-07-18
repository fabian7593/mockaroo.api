package com.mockaroo.api;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;

import jxl.write.WriteException;

import com.mockaroo.api.classes.MockarooFile;
import com.mockaroo.api.helpers.MockarooExcelHelper;
import com.mockaroo.api.interfaces.IMockarooExcelHelper;

/**
 * Class to create a Excel file
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 17/July/2014
 */
public class MockarooExcel extends MockarooFile {

	private String inputFileName;
	private File file;
	private String path;
	private IMockarooExcelHelper mockarooExcel;
	private String sheetName;
	private String language;
	private String country;
	private static final String EXTENSION = ".xls";
	
	/**
	 * Constructor
	 * @param path Path where save the excel file
	 * @param inputFileName Excel file name
	 * @param sheetName Excel sheet name
	 * @param language Language
	 * @param country Country
	 * @throws WriteException 
	 */
	public MockarooExcel(String path, String inputFileName, String sheetName, String language, String country)
			throws WriteException
	{
		mockarooExcel = MockarooExcelHelper.getInstance();
		this.setPath(path);
		this.setInputFileName(inputFileName + EXTENSION);
		this.setSheetName(sheetName);
		this.setLanguage(language);
		this.setCountry(country);
		this.setOutputFile();
	}
	
	/**
	 * Constructor - Default language -> "en" and default country -> "EN"
	 * @param path Path where save the excel file
	 * @param inputFileName Excel file name
	 * @param sheetName Excel sheet name
	 * @throws WriteException 
	 */
	public MockarooExcel(String path, String inputFileName, String sheetName) 
			throws WriteException
	{
		mockarooExcel = MockarooExcelHelper.getInstance();
		this.setPath(path);
		this.setInputFileName(inputFileName);
		this.setSheetName(sheetName);
		this.setLanguage("en");
		this.setCountry("EN");
		this.setOutputFile();
	}

	/**
	 * Get the input file name
	 * @return Input file name
	 */
	private String getInputFileName() {
		return inputFileName;
	}

	/**
	 * Get the file
	 * @return File
	 */
	private File getFile() {
		return file;
	}

	/**
	 * Get the path where save the Excel file
	 * @return Path
	 */
	private String getPath() {
		return path;
	}

	/**
	 * Set the input file name of the Excel file
	 * @param inputFileName Input file name
	 */
	private void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	/**
	 * Set the file
	 * @param file File
	 */
	private void setFile(File file) {
		this.file = file;
	}

	/**
	 * Set the path of the Excel file
	 * @param path Path where save the Excel file
	 */
	private void setPath(String path) {
		this.path = path;
	}

	/**
	 * Get the sheet name of the Excel file
	 * @return Sheet name of the Excel file
	 */
	private String getSheetName() {
		return sheetName;
	}

	/**
	 * Get the language of the Excel file
	 * @return Language of the Excel file
	 */
	private String getLanguage() {
		return language;
	}

	/**
	 * Get the country of the Excel file
	 * @return Country of the Excel
	 */
	private String getCountry() {
		return country;
	}

	/**
	 * Set the sheet name of the Excel file
	 * @param sheetName Sheet name of the Excel file
	 */
	private void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * Set the language of the Excel file
	 * @param language Language of the Excel file
	 */
	private void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Set the country of the Excel file
	 * @param country
	 */
	private void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Set the file
	 */
	private void setOutputFile()
	{
		this.setFile(new File(this.getPath() + this.getInputFileName()));
	}
	
	/**
	 * Write in the Excel file
	 * @throws IOException
	 * @throws WriteException
	 */
	@Override
	public void write(JSONObject jsonObject) throws IOException, WriteException
	{
		mockarooExcel.write(this.getSheetName(), this.getLanguage(), this.getCountry(), this.getFile(), jsonObject);
	}
}