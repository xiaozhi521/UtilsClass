Chunk
    (文本块)是处理文本的最小单位，由一串带格式（包括字体、颜色、大小）的字符串组成。
    Chunk.NEWLINE  换行
    setUnderline(0.2f, -2f)- 下划线
    setTextRise(6)-上浮

    下划线参数详解
        chunk2.setUnderline(Color.BLACK, 0.1f, 0.0F, -2f, 0.0F, 0);
        第一个参数：设置下划线颜色，默认是淡色
        第二个参数 ; 下划线的厚度
        第三个参数 ：设置下划线的颜色深度，第二个参数不变时，此参数增大，下划线也变大。如果没有特殊要求,默认是0 就好
        第四个参数：下划线的位置
        第五个参数：  也是设置下划线的位置
        第六个参数：默认0就好，测试 改到 10 也没什么变化

Phrase
    (短语)由一个或多个Chunk(文本块)组成，Phrase(短语)也可以设定字体，
           但对于其中以设定过字体的Chunk(文本块)无效。通过Phrase(短语)成员函数
           Add可以将一个Chunk(文本块)加入到Phrase(短语)中。
           如：phrase.add(chunk);