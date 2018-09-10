/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azercell.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Mensur Owary
 */
public class ExcelExtractor {
    
    private static XSSFWorkbook book;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    
    private static int totalColCount = 0;
    
    public static Object[][] getData(Class c, String filename, String sheetname){
        return getDataArray(c.getClassLoader().getResourceAsStream(filename), sheetname);
    }
    
    private static Object[][] getDataArray(InputStream input, String sheetName){
        Object[][] array = null;
        
        try{
            book = new XSSFWorkbook(input);
            sheet = book.getSheet(sheetName);
            int totalRowCount = sheet.getLastRowNum();
            setTotalColCount(sheet);
            array = new Object[totalRowCount][totalColCount];
            
            for(int i=1;i<=totalRowCount;i++){
                for(int j=0;j<=totalColCount-1;j++){
                    array[i-1][j] = cellData(i, j);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return array;
    }
    
    private static Object[][] getDataArray(String path, String sheetName){
        Object[][] array = null;
        
        try{
            book = new XSSFWorkbook(new FileInputStream(path));
            sheet = book.getSheet(sheetName);
            int totalRowCount = sheet.getLastRowNum();
            setTotalColCount(sheet);
            array = new Object[totalRowCount][totalColCount];
            
            for(int i=1;i<=totalRowCount;i++){
                for(int j=0;j<=totalColCount-1;j++){
                    array[i-1][j] = cellData(i, j);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return array;
    }
    
    private static void setTotalColCount(XSSFSheet sheet){
        totalColCount = sheet.getRow(0).getLastCellNum();
    }
    
    private static Object cellData(int row, int col){
        Object d = null;
        try{
            cell = sheet.getRow(row).getCell(col);
            switch(cell.getCellTypeEnum()){
                case BOOLEAN:
                    d = cell.getBooleanCellValue();
                    break;
                case STRING:
                    d = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    d = cell.getNumericCellValue();
                    break;
                case ERROR:
                    break;
                case BLANK:
                    d = "";
                    break;
                default:
                    d = null;
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return d;
    }
    
}
