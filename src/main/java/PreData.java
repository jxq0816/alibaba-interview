import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PreData {
    private static String savefile = "data.txt";

    public static void main(String[] args) {

        FileWriter fwriter = null;
        Random random=new Random();
        try {
            fwriter = new FileWriter(savefile);
            for(int i=0;i<400000;i++){
                int as=random.nextInt(400000);
                fwriter.write(as+"");
                fwriter.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
