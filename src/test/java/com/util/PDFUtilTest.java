package com.util;

import com.util.pdf.PDFUtil;
import org.junit.Test;

public class PDFUtilTest {
    @Test
    public void createTablePdf(){
        PDFUtil.createTablePdf();
    }
    @Test
    public void createPhrasePdf(){
        PDFUtil.createPhrasePdf();
    }
    @Test
    public void createChunkPdf(){
        PDFUtil.createChunkPdf();
    }
    @Test
    public void createParagraphPdf(){
        PDFUtil.createParagraphPdf();
    }

    @Test
    public void createRectanglePDF(){
        PDFUtil.createRectanglePDF();
    }

    @Test
    public void createPDF(){
        PDFUtil.createPDF();
    }
}
