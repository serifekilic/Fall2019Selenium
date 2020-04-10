package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {
    @Test
    public void readExcelFileTest() throws Exception {
        //we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();
        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell = firstRow.getLastCellNum();
        System.out.println("###################");
        for (int i = 0; i < lastCell; i++) {
            System.out.print(firstRow.getCell(i) + " | ");
        }

        //last row is 16th--->index 15
        //index of last row
        int numberOfRows = workSheet.getLastRowNum();//cunku index 0 dan baslar, number of rows dedigimiz icin 1 eklemek zorundayiz
        //returns how many rows at all
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

        System.out.println("\n indexOfLastRow = " + numberOfRows);
        System.out.println("\nnumberOfRows2 = " + numberOfRows2);

        System.out.println("#################");
        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }
    }
        @Test
       public void excelUtilityTest(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-all";
            ExcelUtil excelUtil=new ExcelUtil(path, spreadSheet);
            //https://docs.oracle.com/javase/tutorial/java/java00/methodreferences.html

          //  excelUtil.getDataList().forEach(System.out::println);// aynisi 1.yol
         //   excelUtil.getDataList().forEach(p-> System.out.println(p));//2. yol yukaridaki ile ayni isi gorur
         //   System.out.println(excelUtil.getDataList());
            //bu da yukaridaki ikisi ile ayni isi gorur 3.yol
            for(Map<String,String> record:excelUtil.getDataList()){
                System.out.println(record);
            }
        }

        public void getColumnNamesTest(){

        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-short";
        ExcelUtil excelUtil=new ExcelUtil(path,spreadSheet);
        //all column names as collection of String
            System.out.println();
        }
    }

