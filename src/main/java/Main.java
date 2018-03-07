import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String kFile = "data.txt";
        int days = 4000;
        solution(kFile, days);
    }

    public static void solution(String kFile, int x) {
        int max=0;
        int start=0;
        int priceStart=0;
        int end=x;
        int priceEnd=0;
        Queue<Integer> queue = new LinkedList<Integer>();

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream=new FileInputStream(kFile);
            sc = new Scanner(inputStream,"UTF-8");
            //我们将使用Java.util.Scanner类扫描文件的内容，一行一行连续地读取，允许对每一行进行处理，而不保持对它的引用。总之没有把它们存放在内存中：
            int num=0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line!=null){
                    Integer tail=Integer.parseInt(line);//队尾元素
                    queue.add(tail);
                    if(num>=x){
                        Integer head=queue.poll();//获取队头并出队
                        int dis=tail-head;
                        if(dis>max){
                            start=num-x;
                            priceStart=head;
                            end=num;
                            priceEnd=tail;
                            max=dis;//更新
                        }
                    }

                }
                num++;
            }
            System.out.println("数据行："+num);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        System.out.println("在股票价格为A["+start+"]="+priceStart+"时买进，而在A["+end+"]="+priceEnd+"时卖出,最大收益"+max*0.01+"美元");
    }
}