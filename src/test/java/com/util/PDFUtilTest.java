package com.util;

import com.util.pdf.PDFUtil;
import org.junit.Test;

public class PDFUtilTest {
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
