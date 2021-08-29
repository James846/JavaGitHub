import java.io.*;
public class AnalysisResult {
    public static void main(String[] args){
        File fRead=new File("score.txt");
        File fWrite= new File("scoreAnalysis.txt");
        try{
            Writer out =new FileWriter(fWrite,true);
            BufferedWriter bufferWrite=new BufferedWriter(out);
            Reader in=new FileReader(fRead);
            BufferedReader bufferRead=new BufferedReader(in);
            String str;
            while((str=bufferRead.readLine())!=null){
                double totalScore=Fenxi.getTotalScore(str);
                str = str+"总分："+totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("姓名：吴天雄 学号：3200608046");
    }
}

