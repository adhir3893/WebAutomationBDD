package automation.testDataManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigFileReader {
	private XSSFWorkbook workbook = null;
	private XSSFCell cell = null;
	private XSSFRow row = null;
	private XSSFSheet sheet = null;
	private FileInputStream fis;
	private int colCount;
	private int rowCount;
	private Map<String, String> testData;
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + File.separator
			+ "configs//Configuration.properties";

	public void selectExcel(String path) throws IOException {
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				throw (e);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public Map<String, String> getTestData() throws IOException {
		testData = new HashMap<String, String>();
		String path = System.getProperty("user.dir") + File.separator + "bin/AutomationTestData.xlsx";
		String sheetName = "configuration";
		selectExcel(path);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		colCount = row.getLastCellNum();
		rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		System.out.println(colCount);
		for (int i = 0; i <= rowCount; i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue().toString();
			String value = sheet.getRow(i).getCell(1).getStringCellValue().toString();
			// System.out.println(key + " : " + value);
			testData.put(key, value);
		}
		return testData;
	}

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getReportConfigPath() {
		String reportConfigPath = System.getProperty("user.dir") + File.separator
				+ properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

}
