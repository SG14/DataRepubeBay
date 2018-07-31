package DataProviderComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import GenericComponent.ExcelReadWrite;

public class DataProvider_Search {

	@DataProvider(name="dp_search")
	public static Iterator<Object[]> getValidSearchData() throws IOException
	{
	
		List<Object[]> objSearch = search("ValidSearch");
		return objSearch.iterator();
		
	}
	
	public static List<Object[]> search(String scriptname) throws IOException
	{
		ExcelReadWrite xl = new ExcelReadWrite("D:\\Framework\\DataRepubEbay\\TestData\\TestData.xls");
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		int getrowcount = xl.getrowcount(Sheet1);
		int colcount = xl.getcolcount(Sheet1,0);

		
		List<Object[]> arr_list = new ArrayList<Object[]>();
		
		for(int i=1; i<=getrowcount;i++)
		{
			String execute_Flag = xl.Readvalue(Sheet1, i, "Execute_Flag");
			String script_name = xl.Readvalue(Sheet1, i, "Script_name");
			if(execute_Flag.equals("Y")&&(script_name.equals("ValidSearch")))
			{
			Map<String,String> dmap = new HashMap<String, String>();
			for(int j=0; j<colcount; j++) 
			{
				String key= xl.Readvalue(Sheet1, 0, j);
				String value = xl.Readvalue(Sheet1, i, j);
				dmap.put(key, value);
			} //end of for loop
			
			Object[] obj = new Object[1];
			obj[0]=dmap;
			arr_list.add(obj);
			}//end of if condition
			
		}//end of for loop
		return arr_list;
	}
	
	
}
