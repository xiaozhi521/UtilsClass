#### 段落对象：
##### 1、设置标题
        void setAlignment() 方法 可以设定段落的对齐方式，
            可以传 1（居中对齐）,2（右对齐）,3（左对齐）,8,0（不设置默认左对齐）；
            或者字符串：center,Right,Justify,JustifyAll,''
            Element.ALIGN_LEFT， （左对齐）
            Element.ALIGN_CENTER、 （居中对齐）
            Element.ALIGN_RIGHT， （右对齐）
            Element.ALIGN_JUSTIFIED（不设置默认左对齐）
        Paragraph head = new Paragraph("这是标题",headfont);
        head.setAlignment(1);
        head.setAlignment("center");
        document.add(head);
##### 2、设置行间距
        void setLeading(float var1);
        只对当前段落有效
##### 3、设置行间距 1.5倍，1倍
        void setMultipliedLeading(float var1)
##### 4、设置左缩进
        void setIndentationLeft(float var1)
##### 5、设置右缩进
        void setIndentationRight(float var1)
##### 6、设置首行缩进
         void setFirstLineIndent(float var1)
##### 7、设置上空白
        void setSpacingBefore(float var1)
##### 8、设置段落下空
        void setSpacingAfter(float var1)
##### 9、设置段落间距
        void setExtraParagraphSpace(float var1)
##### 10、该值指示是否可以用分页符或分栏符来断开段落的文本 默认 false
    void setKeepTogether(boolean var1)
