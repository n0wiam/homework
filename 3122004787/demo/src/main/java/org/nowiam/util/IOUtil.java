package org.nowiam.util;

import java.io.*;

//读入写出工具
public class IOUtil {
    public static String read(String Path) {
        String txt = "";
        String strLine;
        // 读入输入路径的文件
        File file = new File(Path);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            //设定编码规范为utf-8
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            //缓冲
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 从缓冲区读出
            while ((strLine = bufferedReader.readLine()) != null) {
                txt += strLine;
            }
            // 关闭文本
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    //将double类型结果写到对应文件
    public static void write(double res,String path){
        String txt = Double.toString(res);
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(txt, 0, (txt.length() > 3 ? 4 : txt.length()));
            fileWriter.write("\r\n");
            // 关闭资源
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
