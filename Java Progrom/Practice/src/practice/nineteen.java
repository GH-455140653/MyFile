package practice;

import java.io.*;

public class nineteen {
    public static void main(String[] args) throws IOException {
        String path_output = System.getProperty("user.dir") + "\\cash\\TTT.java";
        String path_input = System.getProperty("user.dir") + "\\cash\\TT.java";
        FileOutputStream output = new FileOutputStream(path_output);
        BufferedOutputStream bout = new BufferedOutputStream(output);
        FileInputStream input = new FileInputStream(path_input);
        BufferedInputStream bin = new BufferedInputStream(input);

//        int b;
//        while ((b=bin.read()) != -1) {
//            bout.write(b);
//            System.out.print((char)b);
//        }

        while (bin.read()!=-1) {
            bout.write(bin.read());
            System.out.print((char) (bin.read()));
        }

        bin.close();
        bout.close();
    }
}
