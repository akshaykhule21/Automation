package testDataManager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.qameta.allure.Allure;

public class ExcelDataReader {
	// Thread local is used for parallel purpose 	
	// so when multiple threads open same variable can handle store diff value for there thread.
	// Below data will come from excel and will be use in threadwise
	private static final String excelpath = "src/main/java/testDataManager/TestData.xlsx";
	private static final ThreadLocal<String> regnumThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> cityThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> rtoThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> makeThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> modelThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> fuelTypeThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> variantThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> regYearThreadLocal = new ThreadLocal<>();
	public void excelDataReader(String sheetName, int rowcount) throws InvalidFormatException, IOException {
	    ExcelReader reader = new ExcelReader();
	    System.out.println("excelreader invoked");

	    List<Map<String, String>> testData = reader.getData(excelpath, sheetName);

	    Map<String, String> rowData = testData.get(rowcount);
	    regnumThreadLocal.set(rowData.get("REGNUM"));
	    cityThreadLocal.set(rowData.get("CITY"));
	    rtoThreadLocal.set(rowData.get("RTO"));
	    makeThreadLocal.set(rowData.get("MAKE"));
	    modelThreadLocal.set(rowData.get("MODEL"));
	    fuelTypeThreadLocal.set(rowData.get("FUELTYPE"));
	    variantThreadLocal.set(rowData.get("VARIANT"));
	    regYearThreadLocal.set(rowData.get("REGYEAR"));
	   	}

	public static String getRegnum() {
	    return regnumThreadLocal.get().trim();
	}

	public static String getCity() {
	    return cityThreadLocal.get().trim();
	}
	
	public static String getRto() {
	    return rtoThreadLocal.get().trim();
	}

	public static String getMake() {
	    return makeThreadLocal.get().trim().toUpperCase();
	}

	public static String getModel() {
	    return modelThreadLocal.get().trim().toUpperCase();
	}

	public static String getFuelType() {
	    return fuelTypeThreadLocal.get().trim().toUpperCase();
	}

	public static String getVariant() {
	    return variantThreadLocal.get();
	}

	public static String getRegYear() {
	    return regYearThreadLocal.get().trim().toUpperCase();
	}
	
	// this method has written just to check whether data comming from excel or not
	public static void main(String[] args) throws InvalidFormatException, IOException {
		ExcelDataReader a =new ExcelDataReader();
		a.excelDataReader("Proposal", 0);
		System.out.println(a.getRegnum());
		System.out.println(a.getCity());
	}
}