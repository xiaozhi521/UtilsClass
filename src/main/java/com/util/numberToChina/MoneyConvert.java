package com.util.numberToChina;

public class MoneyConvert {
    private final String[] str1 = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};
    private final String[] str2 = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private final String[] str3 = {"角", "分"};

    public static void main(String[] args) {
        double n = 6.789;
        MoneyConvert mc = new MoneyConvert();
        String str = mc.convert(n);
        System.out.println(str);
    }

    public String convert(double n) {
        String str = String.valueOf(n);
        String temp1 = str.substring(0, str.indexOf("."));
        String temp2 = str.substring(str.indexOf(".") + 1);
        int k = -1;
        int len = -1;
        StringBuffer sb = new StringBuffer();
        len = temp1.length() - 1;
        for (int i = 0; i < temp1.length(); i++) {
            k = Integer.parseInt(temp1.substring(i, i + 1));
            sb.append(str2[k]).append(str1[len - i]);
        }
        for (int i = 0; i < 2; i++) {
            k = Integer.parseInt(temp2.substring(i, i + 1));
            sb.append(str2[k]).append(str3[i]);
        }
        return sb.toString();
    }
}
