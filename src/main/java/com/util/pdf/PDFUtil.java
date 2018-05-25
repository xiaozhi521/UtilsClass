package com.util.pdf;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import com.util.BugUtil;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  1、建立com.lowagie.text.Document对象的实例。
 *  2、建立一个书写器(Writer) 与document对象关联，通过书写器(Writer) 可以将文档写入到磁盘中
 *  3、打开文档。
 *  4、向文档中添加内容 new Paragraph()。
 *  5、关闭文档。
 * com.lowagie.text.Document对象的构建函数有三个，分别是：
 * 　　public Document();
 * 　　public Document(Rectangle pageSize);
 * 　　public Document(Rectangle pageSize,int marginLeft,int marginRight,int marginTop,int marginBottom);
 */
public class PDFUtil {
    private static Font headfont ;// 设置字体大小
    private static Font keyfont;// 设置字体大小
    private static Font textfont;// 设置字体大小
    private static Font redfont;// 设置字体大小

    static{
        BaseFont bfChinese;
        try {
            //bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            headfont = new Font(bfChinese, 18, Font.BOLD);// 设置字体大小
            keyfont = new Font(bfChinese, 12, Font.BOLD);// 设置字体大小
            textfont = new Font(bfChinese, 12, Font.NORMAL);// 设置字体大小
            redfont = new Font(bfChinese, 14, Font.BOLD,Color.RED);// 红色：设置字体大小
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void createParagraphPdf(){
        try {
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, new FileOutputStream(System.currentTimeMillis() + ".PDF"));
            document.open();
            //设置标题
            Paragraph head = new Paragraph("这是标题",headfont);
            head.setAlignment(1);
            head.setSpacingAfter(10.0f);
            head.setAlignment("Center");
            document.add(head);
            //设置正文
            Paragraph test1 = new Paragraph("这里输入文章报告的正文。首段通常为文章的内容概述，简单概述文章的观点：针对某个问题，通过一定的方法，得到了某个结论。",textfont);
            test1.setFirstLineIndent(26);
            document.add(test1);

            Paragraph test2 = new Paragraph("一、研究背景",textfont);
            test2.setFirstLineIndent(26);
            document.add(test2);

            Paragraph test3 = new Paragraph("第一部分通常为文章的写作背景描述，可以具体描述本文所要研究的问题：问题形成的原因、现状、影响等信息。",textfont);
            test3.setFirstLineIndent(26);
            test3.setSpacingAfter(30);
            document.add(test3);

            Paragraph test4 = new Paragraph("签名：____________",textfont);
            test4.setIndentationLeft(350);
            document.add(test4);

            Paragraph test5 = new Paragraph("_____年____月____日",textfont);
            test5.setIndentationLeft(350);
            test5.setSpacingBefore(15);
            document.add(test5);

            document.close();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建简单的pdf
     */
    public static void createPDF() {
        try{
            //1、建立com.lowagie.text.Document对象的实例。
            Document document = new Document();
            //2、建立一个书写器(Writer) 与document对象关联，通过书写器(Writer) 可以将文档写入到磁盘中
            PdfWriter.getInstance(document, new FileOutputStream("Helloworld.PDF"));
            //3、打开文档。
            document.open();
            //4、向文档中添加内容。
            document.add(new Paragraph("Hello World"));
            //5、关闭文档。
            document.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            BugUtil.addBug(e);
        }catch (DocumentException e){
            e.printStackTrace();
            BugUtil.addBug(e);
        }

    }
}
