package com.util.pdf;

import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
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
    private static Font footerfont;// 设置字体大小
    private static Font chunkfont;// 设置chunk 字体大小
    private static Font phrasefont;// 设置chunk 字体大小

    static{
        BaseFont bfChinese;
        try {
            //bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            headfont = new Font(bfChinese, 18, Font.BOLD);// 设置字体大小
            keyfont = new Font(bfChinese, 12, Font.BOLD);// 设置字体大小
            textfont = new Font(bfChinese, 12, Font.NORMAL);// 设置字体大小
            redfont = new Font(bfChinese, 14, Font.BOLD,Color.RED);// 红色：设置字体大小
            footerfont = new Font(bfChinese, 10, Font.NORMAL,Color.BLACK);//设置页底字体大小
            chunkfont = new Font(bfChinese, 14, Font.BOLDITALIC,Color.RED);//设置Chunk字体大小
            phrasefont = new Font(bfChinese, 14, Font.BOLDITALIC,Color.MAGENTA);//设置phrase字体大小
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建Image对象
     */
    public static void createTablePdf(){
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(System.currentTimeMillis() + ".PDF"));
            document.open();
            //设置标题
            Paragraph head = new Paragraph("一念心清静，莲花处处开-Phrase",headfont);
            head.setAlignment(1);
            head.setSpacingAfter(10.0f);
            head.setAlignment("Center");
            document.add(head);
            Paragraph paragraph = new Paragraph("第一个表格",textfont);
            paragraph.setSpacingAfter(3.0f);
            paragraph.setFirstLineIndent(45.0f);
            paragraph.setAlignment(1);
            document.add(paragraph);
            //设置表格
            PdfPTable table = new PdfPTable(4);//大小必须刚刚好，缺一个单元整行都没了
            String[] content = { "地址：", "北京市", "详细地址", "海淀区"};
            for (int i = 0; i < content.length; i++) {
                PdfPCell cell = new PdfPCell();
                cell.setVerticalAlignment(1);
                cell.addElement(new Paragraph(content[i],textfont));
                table.addCell(cell);
            }
            PdfPCell cell = new PdfPCell();
            cell.addElement(new Paragraph("123",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.addElement(new Paragraph("123222",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.addElement(new Paragraph("123222",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.addElement(new Paragraph("123222",textfont));
            table.addCell(cell);


            cell = new PdfPCell();
            cell.setColspan(2);
            cell.addElement(new Paragraph("123222",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.setColspan(2);
            cell.addElement(new Paragraph("123222",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.addElement(new Paragraph("123222111",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.addElement(new Paragraph("123222111",textfont));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.addElement(new Paragraph("123222111",textfont));
            table.addCell(cell);

            document.add(table);

            document.add(new Paragraph("end",textfont));
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
     * 创建Image对象
     */
    public static void createImagePdf(){
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(System.currentTimeMillis() + ".PDF"));
            document.open();
            //设置标题
            Paragraph head = new Paragraph("一念心清静，莲花处处开-Phrase",headfont);
            head.setAlignment(1);
            head.setSpacingAfter(10.0f);
            head.setAlignment("Center");
            document.add(head);
            //设置正文
            Paragraph test1 = new Paragraph("三生缘，成诗篇，怎挥剑，难了断",textfont);
            test1.setFirstLineIndent(26);
            document.add(test1);

            Image image = Image.getInstance("http://suo.im/54w1fi");
            document.add(image);
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
     * 创建短语对象
     */
    public static void createPhrasePdf(){
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(System.currentTimeMillis() + ".PDF"));
            document.open();
            //设置标题
            Paragraph head = new Paragraph("一念心清静，莲花处处开-Phrase",headfont);
            head.setAlignment(1);
            head.setSpacingAfter(10.0f);
            head.setAlignment("Center");
            document.add(head);
            //设置正文
            Paragraph test1 = new Paragraph("凡心千万，心轮静守，若悟不透，禅语一片，佛心一尊，看芸芸众生里，多少的人，不是一路艰辛，泪流满面，一路开怀，欢语一生，唯叹自己的人生路，荆棘坎坷，这也许上苍赠与的最好礼物，没历经风雨的人生，是无法承载，生命中的厚重！",textfont);
            test1.setFirstLineIndent(26);
            Chunk chunk1 = new Chunk("世间有两朵相同的花，一朵凋零一朵绽！",chunkfont);
            chunk1.setBackground(Color.CYAN); //设置背景色
            test1.add(chunk1);
            //设置Phrase
            Phrase phrase = new Paragraph("姻缘线，许相见，怎牵绊，难执念",phrasefont);
            phrase.add(chunk1);

//            test1.add(chunk1);  //执行此语句会将 "凡心千万....." 替换掉
            document.add(phrase);
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
     * 创建文本对象
     */
    public static void createChunkPdf(){
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(System.currentTimeMillis() + ".PDF"));
            document.open();
            //设置标题
            Paragraph head = new Paragraph("这是Chunk",headfont);
            head.setAlignment(1);
            head.setSpacingAfter(10.0f);
            head.setAlignment("Center");
            document.add(head);
            //设置正文
            Paragraph test1 = new Paragraph("这里输入文章报告的正文。首段通常为文章的内容概述，简单概述文章的观点：针对某个问题，通过一定的方法，得到了某个结论。",textfont);
            test1.setFirstLineIndent(26);
            Chunk chunk1 = new Chunk("世间有两朵相同的花，一朵凋零一朵绽！",chunkfont);
            chunk1.setBackground(Color.CYAN); //设置背景色
            test1.add(chunk1);
            document.add(test1);

            //设置下划线
            Chunk chunk2 = new Chunk("                          ",chunkfont);
//            chunk2.setUnderline(0.2f, -2f); //对应下面第二个和第四个参数
            chunk2.setUnderline(Color.BLACK, 0.1f, 0.1F, -2f, 0.0F, 0);
            document.add(chunk2);


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
     * 创建段落对象
     */
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
     *  Rectangle 对象操作
     */
    public static void createRectanglePDF() {
        try{
            Rectangle rectangle = new Rectangle(PageSize.A4);
            //设置背景色
            rectangle.setBackgroundColor(Color.CYAN);
            //横向打印
            rectangle.rotate();
            //设置边框
            rectangle.setBorder(Element.ALIGN_CENTER);
            Document document = new Document(rectangle);
            PdfWriter.getInstance(document, new FileOutputStream(System.currentTimeMillis() + ".PDF"));

            //第一个参数默认显示页数 ，  第二个参数传 true  显示页数，传 false  不显示页数
            HeaderFooter footer = new HeaderFooter(new Phrase("",footerfont),true);
            footer.setAlignment(1);
            footer.setBorder(Rectangle.NO_BORDER);
            document.setFooter(footer);

            document.open();
            document.add(new Paragraph("Hello Rectangle"));

            document.newPage();

            document.add(new Paragraph("Hello World1,this page 2"));
            document.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (DocumentException e){
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

            document.newPage();

            document.add(new Paragraph("Hello World1,this page 2"));
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
