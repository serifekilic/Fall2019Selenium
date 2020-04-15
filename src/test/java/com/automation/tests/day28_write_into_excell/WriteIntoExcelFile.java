package com.automation.tests.day28_write_into_excell;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;
import java.time.LocalDateTime;

/*
//when you create FileOutPutSteam objt
fileOut.close(); // make sure to close it after writing(or after any other manipulation),
otherwise the file will be broken.

//whenever you create a cell, it does not mean that all cell under neat will created automatically
//So first we created object of second row then we created new cell and write date and time information
 */
public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream=new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);//2nd row
        Cell cell = row.getCell(5);//get result column
        System.out.println("Before: " + cell.getStringCellValue());
        cell.setCellValue("FAILED");//I am changing from n/a to passed
        System.out.println("After: " + cell.getStringCellValue());
        Row firstRow = sheet.getRow(0); // get first row
        Cell newCell = firstRow.createCell(6);//create new cell
        newCell.setCellValue("Date of execution");//give the name to this cell


        //write date and time info into second row, last column
        Row secondRow = sheet.getRow(1);
        Cell newCell2 = secondRow.createCell(6);//create a cell
        newCell2.setCellValue(LocalDateTime.now().toString());//I will set current date and time info into new cell


        Row thirdRow=sheet.getRow(1);
        Cell newCell3=thirdRow.createCell(6);
        newCell3.setCellValue("Thank you :)");

        Row fRow=sheet.getRow(2);
        Cell newCell4=fRow.createCell(6);
        newCell4.setCellValue("You're Welcome");

        Row groupRow=sheet.getRow(0);
        Cell groupCell=groupRow.createCell(7);
        groupCell.setCellValue("GroupMembers");

        Row groupRow1=sheet.getRow(1);
        Cell groupCell1=groupRow1.createCell(7);
        groupCell1.setCellValue("Serife");


        //I crete if I want to write something into the file
        //don't forget to close excel file if you opened it
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);//write changes
        workbook.close();//close when everything is done
        outputStream.close();
        /**
         * Close the underlying input resource (File or Stream),
         *  from which the Workbook was read.
         *
         * <p>Once this has been called, no further
         *  operations, updates or reads should be performed on the
         *  Workbook.
         */
    }
}




