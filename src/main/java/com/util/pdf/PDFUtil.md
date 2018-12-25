##### com.lowagie.text.Paragraph：表示一个缩进的文本段落，在段落中，你可以设置对齐方式，缩进，段落前后间隔等。
##### com.lowagie.text.Chapter：表示PDF的一个章节，他通过一个Paragraph类型的标题和整形章数创建。
##### com.lowagie.text.Font：这个类包含了所有规范好的字体，包括family of font，大小，样式和颜色，所有这些字体都被声明为静态常量。
##### com.lowagie.text.List：表示一个列表；
##### com.lowagie.text.pdf.PDFPTable：表示一个表格；
##### com.lowagie.text.Anchor：表示一个锚，类似于HTML页面的链接。
##### com.lowagie.text.pdf.PdfWriter：当这个PdfWriter被添加到PdfDocument后，所有添加到Document的内容将会写入到与文件或网络关联的输出流中。
##### com.lowagie.text.pdf.PdfReader：用于读取PDF文件；
#### 生成PDF文档需要5个步骤：
    1、建立com.lowagie.text.Document对象的实例。
    2、建立一个书写器(Writer) 与document对象关联，通过书写器(Writer) 可以将文档写入到磁盘中
    3、打开文档。
    4、向文档中添加内容 new Paragraph()。
    5、关闭文档。
##### com.lowagie.text.Document对象的构建函数有三个，分别是：
   - public Document(); 默认方法：A4，36，36，36，36
   - public Document(Rectangle pageSize);
   - public Document(Rectangle pageSize,int marginLeft,int marginRight,int marginTop,int marginBottom);分别指pdf页面大小和内容距离文档边的距离
#### 设定文档属性
   - 在文档打开之前，可以设定文档的标题、主题、作者、关键字、装订方式、创建者、生产者、创建日期等属性，调用的方法分别是：
   
        
        public boolean addTitle(String title)
        public boolean addSubject(String subject)
        public boolean addKeywords(String keywords)
        public boolean addAuthor(String author)
        public boolean addCreator(String creator)
        public boolean addProducer()
        public boolean addCreationDate()
        public boolean addHeader(String name, String content)
    其中方法addHeader对于PDF文档无效，addHeader仅对html文档有效，用于添加文档的头信息。
    
    
   - 当新的页面产生之前，可以设定页面的大小、书签、脚注（HeaderFooter）等信息，调用的方法是：
   
   
       public boolean setPageSize(Rectangle pageSize)
    　　public boolean add(Watermark watermark)
    　　public void removeWatermark()
    　　public void setHeader(HeaderFooter header)
    　　public void resetHeader()
    　　public void setFooter(HeaderFooter footer)
    　　public void resetFooter()
    　　public void resetPageCount()
    　　public void setPageCount(int pageN)
    

  - 如果要设定第一页的页面属性，这些方法必须在文档打开之前调用。
            
            
    对于PDF文档，iText还提供了文档的显示属性，通过调用书写器的setViewerPreferences方法可以控制文档打开时Acrobat Reader的显示属性，
    如是否单页显示、是否全屏显示、是否隐藏状态条等属性。
    另外，iText也提供了对PDF文件的安全保护，通过书写器（Writer）的setEncryption方法，可以设定文档的用户口令、只读、可打印等属性。
#### 文档方法
   - add()-添加内容，newPage()-下一页， addDocListener-监听器

   - getPageNumber()-第几页 ，getPageSize-页面大小 ，

   - top|left|right|bottom-页面预定义位置，置页眉页脚或者页码时有用，内部调用Rectangle的属性

   - setJavaScript_onLoad（添加js）等等
#### 添加文档内容
    所有向文档添加的内容都是以对象为单位的，如Phrase、Paragraph、Table、Graphic对象等。比较常用的是段落(Paragraph)对象，用于向文档中添加一段文字。

#### 文本处理
    iText中用文本块(Chunk)、短语(Phrase)和段落(paragraph)处理文本。
    文本块(Chunk)是处理文本的最小单位，有一串带格式（包括字体、颜色、大小）的字符串组成。如以下代码就是产生一个字体为HELVETICA、大小为10、带下划线的字符串：
        Chunk chunk1 = new Chunk("This text is underlined", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE));

    短语(Phrase)由一个或多个文本块(Chunk)组成，短语(Phrase)也可以设定字体，但对于其中以设定过字体的文本块 (Chunk)无效。通过短语(Phrase)成员函数add可以将一个
    文本块(Chunk)加到短语(Phrase)中， 如：phrase6.add(chunk);

    段落(paragraph)由一个或多个文本块(Chunk)或短语(Phrase)组成，相当于WORD文档中的段落概念，同样可以设定段落 的字体大小、颜色等属性。

    另外也可以设定段落的首行缩进、对齐方式（左对齐、右对齐、居中对齐）。通过函数setAlignment可以设定段落的对齐方 式，
    setAlignment的参数1为居中对齐、2为右对齐、3为左对齐，默认为左对齐。
#### 表格处理
    iText中处理表格的类为：com.lowagie.text.Table和 com.lowagie.text.PDF.PDFPTable，对于比较简单的表格处理可以用com.lowagie.text.Table，
    但是如果 要处理复杂的表格，这就需要com.lowagie.text.PDF.PDFPTable进行处理。这里就类 com.lowagie.text.Table进行说明。

 - 类com.lowagie.text.Table的构造函数有三个：
        Table (int columns)
        Table(int columns, int rows)
        Table(Properties attributes)

- 参数columns、rows、attributes分别为表格的列数、行数、表格属性。创建表格时必须指定表格的列数，而对于行数可以不用指定。

- 建立表格之后，可以设定表格的属性，如：边框宽度、边框颜色、衬距（padding space 即单元格之间的间距）大小等属性。

  - 创建表格时必须指定表格的列数，而对于行数可以不用指定。
  - 建立表格，可以设定表格的属性：
    - 设置表格的边逛大小
            table.setBorderWidth(int arg);
    - 设置表格的对齐方式： 1为居中对齐，2为右对齐，3为左对齐
            table.setAlignment(1);
    - 设置表格的边逛颜色
            table.setborderColor(new Color(0,0,255));参数也可以Color.GREEN
    - 设置每个单元格中的内容和边框的间距
            table.setPadding(int arg);
    - 设置单元格的边框和边框的间距
            table.setSpacing(int arg);
  - 创建单元格
    - 无参数的构造函数
            Cell cell = new Cell();
    - 带String类型参数的构造函数,可以直接输入文字
            Cell cell = new Cell(String arg);
    - 带Element参数的构造函数，可以是元素，图片信息等
            Cell cell = new Cell(Element arg);
    - 设置该单元格跨表格的几行，不跨行则不用指定
            cell.setRowspan(int arg);
    - 设置该单元格跨表格的几列，不跨行则不用指定
            cell.setColspan(int arg);
    - 为单元格添加一个元素，可以是元素，图片信息等
            cell.addElement(Element arg);
    - 如果要添加中文，则需要如下:   fontChinese为上面定义的中文处理对象
            cell.addElement(new Paragraph("中文", fontChinese));
    - 往表格中直接添加字符串，
            table.addCell(String arg);
    - 往表格中添加单元格对象Cell
            table.addCell(Cell cell);
    - 往表格中添加单元格(cell)时，按自左向右，从上而下的次序添加