package experiment;

import java.io.*;

public class shiyan_11_3 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\cash";
        FileWriter output = new FileWriter(path + "\\aa.txt");
        BufferedWriter bout = new BufferedWriter(output);
        FileReader input = new FileReader(path + "\\a.txt");
        BufferedReader bin = new BufferedReader(input);
        String str = null;
        while ((str = bin.readLine()) != null) {
            System.out.println(str);
            String replace = str.replace("AA", "BB");
            bout.write(replace + "\n");
        }
        bin.close();
        bout.close();
    }
}
