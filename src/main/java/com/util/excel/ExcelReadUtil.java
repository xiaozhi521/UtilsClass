package com.util.excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;

public class ExcelReadUtil {
    /**
     * 读取Excel 表格 并返回 ArrayList
     * @param file
     */
    public static ArrayList readExcel(File file) {
        ArrayList list = new ArrayList();
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数  i为 1 从第2行开始读取数据
                for (int i = 1; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    ArrayList list1 = new ArrayList();
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        list1.add(cellinfo);
                    }
                    list.add(list1);
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (BiffException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    /**
     * 读取Excel 表格 并返回 ArrayList
     * @param file
     */
    public static ArrayList readExcel(File file,int line) {
        ArrayList list = new ArrayList();
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数  i为 1 从第2行开始读取数据
                for (int i = line; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    ArrayList list1 = new ArrayList();
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        list1.add(cellinfo);
                    }
                    list.add(list1);
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (BiffException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public static void main(String[] args) {
        System.out.println(readExcel(new File("src/main/java/com/util/excel/2017CPU排行.xls"),0));
    }
}
