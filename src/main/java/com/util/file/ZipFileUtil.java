package com.util.file;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ZipFileUtil {
    private static byte[] _byte = new byte[1024];

    /**
     * 对.zip文件进行解压缩
     *
     * @param filePath 解压缩文件路径
     * @param descDir  压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return
     */
    public static void unZipFile(String filePath, String descDir) {
        try {
            ZipFile zipFile = new ZipFile(new File(filePath), "GBK");
            for (Enumeration entries = zipFile.getEntries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                File file = new File(descDir + File.separator + entry.getName());
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parent = file.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    InputStream in = zipFile.getInputStream(entry);
                    OutputStream out = new FileOutputStream(file);
                    int len = 0;
                    while ((len = in.read(_byte)) > 0) {
                        out.write(_byte, 0, len);
                    }
                    in.close();
                    out.flush();
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩文件或路径
     *
     * @param zip      压缩的目的地址
     * @param srcFiles 压缩的源文件
     */
    public static void zipFile(String zip, List<File> srcFiles) {
        try {
            if (zip.endsWith(".zip") || zip.endsWith(".ZIP")) {
                ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(new File(zip)));
                zipOut.setEncoding("GBK");
                for (File f : srcFiles) {
                    handlerFile(zip, zipOut, f, "");
                }
                zipOut.close();
            } else {
                System.out.println("target file[" + zip + "] is not .zip type file");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     * @param zip     压缩的目的地址
     * @param srcFile 被压缩的文件信息
     * @param path    在zip中的相对路径
     * @throws IOException
     */
    private static void handlerFile(String zip, ZipOutputStream zipOut, File srcFile, String path) throws IOException {
        System.out.println(" begin to compression file[" + srcFile.getName() + "]");
        if (!"".equals(path) && !path.endsWith(File.separator)) {
            path += File.separator;
        }
        if (!srcFile.getPath().equals(zip)) {
            if (srcFile.isDirectory()) {
                File[] files = srcFile.listFiles();
                if (files.length == 0) {
                    zipOut.putNextEntry(new ZipEntry(path + srcFile.getName() + File.separator));
                    zipOut.closeEntry();
                } else {
                    for (File f : files) {
                        handlerFile(zip, zipOut, f, path + srcFile.getName());
                    }
                }
            } else {
                InputStream in = new FileInputStream(srcFile);
                zipOut.putNextEntry(new ZipEntry(path + srcFile.getName()));
                int len = 0;
                while ((len = in.read(_byte)) > 0) {
                    zipOut.write(_byte, 0, len);
                }
                in.close();
                zipOut.closeEntry();
            }
        }
    }

    /**
     * 对临时生成的文件夹和文件夹下的文件进行删除
     */
    public static void deletefile(String delpath) {
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + File.separator + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + File.separator + filelist[i]);
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        deletefile("D:\\工程项目文件夹\\随意考11\\");
//        unZipFile("D:\\工程项目文件夹\\随意考.zip", "D:\\工程项目文件夹\\随意考11\\");

//        File file = new File("D:\\工程项目文件夹\\随意考.rar");
//        File file1 = new File("D:\\工程项目文件夹\\app版本跟新流程\\企问版本更新工作流(1).docx");
//        List<File> list = new ArrayList<>();
//        list.add(file);
//        list.add(file1);
//        zipFile("D:\\\\工程项目文件夹\\新建文件夹\\随意考12.zip", list);

        File file = new File("D:\\工程项目文件夹\\随意考");
        String path = "D:\\工程项目文件夹\\新建文件夹\\随意考12.zip";
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(new File(path)));
        zipOut.setEncoding("GBK");
        handlerFile(path,zipOut,file,"");
        zipOut.close();

    }
}
