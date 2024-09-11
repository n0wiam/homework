package org.nowiam;
import org.nowiam.util.IOUtil;
import org.nowiam.util.SimHashUtil;
import org.nowiam.util.HammingUtil;
public class Main {
    public static void main(String[] args) {
        if(args.length<3)
        {
            System.out.println("参数错误");
            return ;
        }
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String txt0 = IOUtil.read(args[0]);
        String txt1 = IOUtil.read(args[1]);
        //System.out.println(txt0);
        //String txt0 = IOUtil.read("E:/tem/test/orig.txt");
        //String txt1 = IOUtil.read("E:/tem/test/orig_0.8_add.txt");
        if(txt1.length()<10||txt0.length()<10)
        {
            System.out.println("文本过小");
            return ;
        }
        String resultFileName = args[2];
        //String resultFileName = "E:/tem/test/res1.txt";
        // 由字符串得出对应的 simHash值
        String simHash0 = SimHashUtil.getSimHash(txt0);
        String simHash1 = SimHashUtil.getSimHash(txt1);
        // 由 simHash值求出相似度
        double result = HammingUtil.getResult(simHash0, simHash1);
        // 把相似度写入最后的结果文件中
        IOUtil.write(result, resultFileName);
        if(result<0)
        {
            System.out.println("error");
            return ;
        }
        // 退出程序
        System.exit(0);
    }
}
