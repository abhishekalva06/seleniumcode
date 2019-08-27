
package com.foradianTechnologiesV1.pageObjects;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecuteLeadTest{
	
	static Keywords keyword;
	//static FirefoxDriver driver;
	public static void main(String[] args) throws Exception{
		
		
		keyword = new Keywords();
		//create arraylist to store excel file data in it
		ArrayList data = new ArrayList();
		
		
		//PART 1--> opening file
	FileInputStream file = new FileInputStream("/home/foradian/eclipse-workspace/foradianTechnologiesV2/src/test/java/LeadSuite.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("ApplicantEnquiry");
	
	//PART 2--> setting up iterator(point on top of sheet)
	Iterator row = sheet.iterator();
	
	//check for row and putting value 
	while(row.hasNext()) {
	Row rowIterator=(Row)row.next(); 
	
	//point on top of row
	Iterator cellItr=rowIterator.cellIterator();
	//check for column/cell and putting value to celldata
	
	// PART 3-->fetching value after analyzing what value is there in the sheet
	while(cellItr.hasNext()) {
		Cell cell=(Cell)cellItr.next(); //address of data will be stored in rowitr and cellitr
		//analyze the value in that cell and go to the required case and read the value
	
		switch(cell.getCellType()) {
		case Cell.CELL_TYPE_STRING: 
			data.add(cell.getStringCellValue());
		     break;
		
		case Cell.CELL_TYPE_BOOLEAN:
			data.add(cell.getBooleanCellValue());
			  break;
			  
		case Cell.CELL_TYPE_NUMERIC: 
			data.add(cell.getNumericCellValue());
		      break;
		      
		case Cell.CELL_TYPE_FORMULA: 
			data.add(cell.getStringCellValue());
		      break;
		}
			 
	}
	
	}
	
	//PART 4--> (outside while, inside main) Excel code
	
	for(int i=0;i<data.size();i++) {
		//openbrowser
		if(data.get(i).equals("openbrowser")) {
			String Keyword=(String)data.get(i);
			String Data=(String)data.get(i+1);
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			
			System.out.println(data.get(i));
			keyword.openbrowser();
			
			if(Runmode.equals("yes")) {
			keyword.openbrowser();
			}
		
		}
	
		//navigate
		if(data.get(i).equals("navigate")) {
			String Keyword=(String)data.get(i);
			String Data=(String)data.get(i+1);
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
				keyword.navigate(Data);
			}
			
		}
		
		//sendKeys or input data
		if(data.get(i).equals("input")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword = (String)data.get(i);
			String Data = (String)data.get(i+1);
			String ObjectName = (String)data.get(i+2);
			String Runmode = (String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
				keyword.input(Data,ObjectName);
			}
			
		}
		
		//inputint
		if(data.get(i).equals("inputint")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword = (String)data.get(i);
			int Data= (int)Math.round((Double) data.get(i + 1));
			String converted_data = String.valueOf(Data);
			System.out.println("\n\n\n\n\n\n  value for inputint: "+converted_data);

			String ObjectName = (String)data.get(i+2);
			String Runmode = (String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
				keyword.inputint(converted_data,ObjectName);
			}
			
		}
		
		
		//inputintwithchar
				if(data.get(i).equals("inputintwithchar")) {
					//System.out.println("\n\n\n\n\n\n" + data.get(i));
					String Keyword = (String)data.get(i);
					System.out.println("\n\n\n\n\n\n  value for inputint: "+(String) data.get(i + 1));
					String Data= (String) data.get(i + 1);
					String converted_data = String.valueOf(Data);
					CharSequence converted_new_data = converted_data;
					System.out.println("\n\n\n\n\n\n  value for inputint: "+converted_data);

					String ObjectName = (String)data.get(i+2);
					String Runmode = (String)data.get(i+3);
					System.out.println(Keyword);
					System.out.println(converted_data);
					System.out.println(ObjectName);
					System.out.println(Runmode);
					if(Runmode.equals("yes")) {
						keyword.inputintwithchar(converted_new_data,ObjectName);
					}
					
				}
		
		
		
		
		
		
		//click
		if(data.get(i).equals("click")) {
			String Keyword=(String)data.get(i);
			String Data=(String)data.get(i+1);
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
				keyword.click(ObjectName);
			}
			
		}
															
			//sleep
			if(data.get(i).equals("sleep")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword=(String)data.get(i);
			//String Data=(String)data.get(i+1);
			//int Data = Integer.parseInt((String) data.get(i + 1));
			int Data = (int)Math.round((Double) data.get(i + 1));
			//int Data=(int)data.get(i+1));
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
					keyword.sleep(ObjectName,Data);
			}
						
		}

			//selectbyindex
			if(data.get(i).equals("selectbyindex")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword=(String)data.get(i);
			//String Data=(String)data.get(i+1);
			//	int Data = Integer.parseInt((String) data.get(i + 1));
			//	int a = (int)Math.round((Double) data.get(i + 1));									
			//	this is to find out the value replace a with value(data.get(i+1 etc))
			//	System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+a );
			int Data= (int)Math.round((Double) data.get(i + 1));
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
				keyword.selectbyindex(ObjectName,Data);
			}
					
		}
				
			//selectbyvisibletextstring
				
			if(data.get(i).equals("selectbyvisibletextstring")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword=(String)data.get(i);
			//String Data=(String)data.get(i+1);
			//int Data = Integer.parseInt((String) data.get(i + 1));
			//int a = (int)Math.round((Double) data.get(i + 1));
			//System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+a );
			//System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+Double.toString((Double) data.get(i + 1)) );
			System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+String.valueOf(data.get(i + 1)) );
			String Data= String.valueOf(data.get(i + 1));
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
					keyword.selectbyvisibletextstring(ObjectName,Data);
			}
						
		}
				
			//selectbyvisibletextinteger
			if(data.get(i).equals("selectbyvisibletextint")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword=(String)data.get(i);
			//String Data=(String)data.get(i+1);
			//int Data = Integer.parseInt((String) data.get(i + 1));
			//int a = (int)Math.round((Double) data.get(i + 1));
			//System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+a );
			//System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+Double.toString((Double) data.get(i + 1)) );
			System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+String.valueOf(data.get(i + 1)) );
			//String Data= String.valueOf(data.get(i + 1));
						
			//in data.get(i+1) we will get double value, so we need to convert this double value to int value
			int Data= (int)Math.round((Double) data.get(i + 1));
			//then in the keyword method function, we need string value so we need to convert int to string and pass that value
			String converted_data = String.valueOf(Data);
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
					keyword.selectbyvisibletextint(ObjectName,converted_data);
			}
						
		}
					
				
				
			//selectbyvalue
			if(data.get(i).equals("selectbyvalue")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword=(String)data.get(i);
			//String Data=(String)data.get(i+1);
			//int Data = Integer.parseInt((String) data.get(i + 1));
			//int a = (int)Math.round((Double) data.get(i + 1));										
			//this is to find out the value replace a with value(data.get(i+1 etc))
			//System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+a );
			System.out.println("\n\n\n\n\n\n\n\n  This is my value: "+String.valueOf(data.get(i + 1)) );
			//String Data= String.valueOf(data.get(i + 1));
			//first convert double value to integer
			//then integr value is being converted to string
			int a= (int)Math.round((Double) data.get(i + 1));
			String Data= String.valueOf(a);
			//int Data= (int)Math.round((Double) data.get(i + 1));
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
					keyword.selectbyvalue(ObjectName,Data);
			}
					
		}
				
			
			//robot
			if(data.get(i).equals("robot")) {
			//System.out.println("\n\n\n\n\n\n" + data.get(i));
			String Keyword=(String)data.get(i);
			//String Data=(String)data.get(i+1);
			//int Data = Integer.parseInt((String) data.get(i + 1));
			String Data = (String)data.get(i+1);																								
			String ObjectName=(String)data.get(i+2);
			String Runmode=(String)data.get(i+3);
			System.out.println(Keyword);
			System.out.println(Data);
			System.out.println(ObjectName);
			System.out.println(Runmode);
			if(Runmode.equals("yes")) {
					keyword.robot(ObjectName,Data);
			}
						
		}
					
		

																													
	}

	
}
}