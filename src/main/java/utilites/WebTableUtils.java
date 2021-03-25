package utilites;

import java.util.List;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class WebTableUtils {
	
 Page page;
	public WebTableUtils(Page page) {
		this.page = page;
	}
	
	public String clickOrGetText(String tableXpath, String KeyVal, String colToGet) throws Exception {			
		int colIndex = -1;
		boolean found = false;
		String retVal = "";

		ElementHandle Table =  page.querySelector(tableXpath);
		List<ElementHandle> Rows =Table.querySelectorAll("tr");
		List<ElementHandle> ColHeaders = Rows.get(0).querySelectorAll("th");  //.findElements(By.tagName("th"));
		for(int i=0; i < ColHeaders.size(); i++){
			if (ColHeaders.get(i).innerText().toLowerCase().contains(colToGet.toLowerCase())){
				//println ColHeaders.get(i).innerText();
				colIndex =i;
				break;
			}
		}
		outerLoop:
		for(int i=0; i < Rows.size(); i++){
			List<ElementHandle> Cols =Rows.get(i).querySelectorAll("td"); //.findElements(By.tagName("td"));
			int colSize = Cols.size();
			for(int j = 0; j < Cols.size(); j++){

				if (Cols.get(j).innerText().toLowerCase().contains(KeyVal.toLowerCase())){
					//return Cols.get(colIndex).click();
					return Cols.get(colIndex).innerText();
				}
			}
		}
		if(found){
			return retVal;
		}else{
			throw new Exception(KeyVal +"Was NOt Found");
		}
	}
}
