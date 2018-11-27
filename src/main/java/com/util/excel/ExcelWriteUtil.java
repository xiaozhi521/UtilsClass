package com.util.excel;

import jxl.Workbook;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.Label;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteUtil {
    public static ArrayList arrayList = ExcelReadUtil.readExcel(new File("src/main/java/com/util/excel/2017CPU排行.xls"),0);
    /*
        [[排名, 处理器, 分数],
        [1, IntelAXeonAE5C2679Av4ABA250GHz, 25236], [2, IntelAXeonAE5C2698Av4ABA220GHz, 24615],
        [3, IntelAXeonAE5C2697Av4ABA230GHz, 23070], [4, IntelAXeonAE5C2690Av4ABA260GHz, 22843],
        [5, IntelAXeonAE5C2696Av3ABA230GHz, 22735], [6, IntelAXeonAE5C2699Av3ABA230GHz, 22520],
        [7, IntelAXeonAE5C2696Av4ABA230GHz, 21954]]
     */
    //创建简单的excel表
    public static void createExcel(){
        WritableWorkbook workbook = null;
        WritableSheet  sheet = null;
        try {
            long name  = System.currentTimeMillis();
            workbook = Workbook.createWorkbook(new File("E:\\excel\\test" + name + ".xls"));

            //创建新的一页
            sheet = workbook.createSheet("First Sheet",0);

            //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
            Label label00 = new Label(0,0,"排名");
            sheet.addCell(label00);
            Label label10 = new Label(1,0,"处理器");
            sheet.addCell(label10);
            Label label20 = new Label(2,0,"分数");
            sheet.addCell(label20);

            Label label01 = new Label(0,1,"1");
            sheet.addCell(label01);
            Label label11 = new Label(1,1,"IntelAXeonAE5C2679Av4ABA250GHz");
            sheet.addCell(label11);
            Label label21 = new Label(2,1,"25236");
            sheet.addCell(label21);

            Label label02 = new Label(0,2,"2");
            sheet.addCell(label02);
            Label label12 = new Label(1,2,"IntelAXeonAE5C2698Av4ABA220GHz");
            sheet.addCell(label12);
            Label label22 = new Label(2,2,"24615");
            sheet.addCell(label22);

            //创建第二个表格
            sheet = workbook.createSheet("second Sheet",1);
            //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
            Label label200 = new Label(0,0,"排名");
            sheet.addCell(label200);
            Label label210 = new Label(1,0,"处理器");
            sheet.addCell(label210);
            Label label220 = new Label(2,0,"分数");
            sheet.addCell(label220);
            workbook.write();
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }finally {
            if(workbook != null){
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void createExcel(File file,List list){
        WritableWorkbook workbook = null;
        WritableSheet  sheet = null;
        try {
            //创建表格
            workbook = Workbook.createWorkbook(file);
            //创建第一个表
            sheet = workbook.createSheet("First Sheet",0);
            //设置 sheet
            sheet.mergeCells(0, 0, 3, 0); // 合并单元格
            sheet.setRowView(0, 300); // 设置行的高度
            sheet.setColumnView(0, 10); // 设置列的宽度
            sheet.setColumnView(1, 50); // 设置列的宽度
            sheet.setColumnView(2, 15); // 设置列的宽度
            //设置单元格格式
            WritableFont titleWf = new WritableFont(
                     WritableFont.createFont("仿宋_GB2312"),// 字体
                    12,//WritableFont.DEFAULT_POINT_SIZE,  // 字号
                    WritableFont.NO_BOLD,                    // 粗体
                    false,                                     // 斜体
                    UnderlineStyle.NO_UNDERLINE,            // 下划线
                    Colour.BLACK,                            // 字体颜色
                    ScriptStyle.NORMAL_SCRIPT);
            WritableCellFormat cellFormat = new WritableCellFormat(titleWf);
            cellFormat.setBackground(Colour.GRAY_25);// 设置单元格的背景颜色
            cellFormat.setAlignment(Alignment.CENTRE); // 设置对齐方式
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THICK); // 添加边框
            Label label = null;
            for(int colum = 0; colum < list.size(); colum++){
                List arrayChild = (List) list.get(colum);
                label = new Label(0, colum,arrayChild.get(0).toString(),cellFormat);
                sheet.addCell(label);

                WritableFont titleWf2 = new WritableFont(WritableFont.createFont("黑体"),11);
                WritableCellFormat cellFormatYello = new WritableCellFormat(titleWf2);
                cellFormatYello.setBackground(Colour.YELLOW);
                cellFormatYello.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
                label = new Label(1, colum,arrayChild.get(1).toString(),cellFormatYello);
                sheet.addCell(label);

                //存储字符串类型
                if(colum == 0){
                    label = new Label(2, colum,arrayChild.get(2).toString(),cellFormat);
                    sheet.addCell(label);
                }else{
                    //存贮数值类型
                    double double1 = Double.parseDouble(arrayChild.get(2).toString());
                    Number numberFormat = new Number(2, colum,double1,cellFormat);
                    sheet.addCell(numberFormat);
                }
            }
            //想表里写数据
            workbook.write();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(workbook != null){
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        createExcel(new File("E:\\excel\\test" + System.currentTimeMillis() +".xls"),arrayList);
    }



}
