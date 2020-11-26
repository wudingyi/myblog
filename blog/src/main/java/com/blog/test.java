package com.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;
import java.io.*;
public class test {
    /**
     * 压缩一个文件到一个zip
     * @param in 输入的文件
     * @param out 输出的zip名
     * @param outEntry zip中的条目名
     */
    public static void zip(String in,ZipOutputStream out,String outEntry) {
        File inf = new File(in) ;
        FileInputStream ins;
        try {
            if(inf.exists()){
                ins = new FileInputStream(inf);

//文件夹根据需求动态填充
                out.putNextEntry(new ZipEntry("文件夹"+"/"+outEntry));
                int b ;
                while ((b = ins.read()) != -1) {
                    out.write(b);
                }
                ins.close();
            }else{
//按照项目的需要在没有的时候给予提示吧。
                System.out.println("系统找不到指定文件："+in);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /**
     *
     * @param out 输出的zip名
     * @param in 输入的目录
     * @param inEntrys 输入的条目集合
     */
    public static void zip(String out,String in,List<String> inEntrys) {
        try {
            OutputStream zipFileName_fileOutputStream = new FileOutputStream(out);
            ZipOutputStream zipOutputStream = new ZipOutputStream(zipFileName_fileOutputStream);
            for(String inEntry:inEntrys){
                zip(in+inEntry,zipOutputStream,inEntry);
            }
            zipOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        List<String> inEntrys=new ArrayList<String>();
        inEntrys.add("a.txt");
        inEntrys.add("b.txt");
//可以加一个实际没有的文件试试
        inEntrys.add("c.txt");

        zip("d:\\a\\a3.zip","d:\\a\\",inEntrys);

    }
}
