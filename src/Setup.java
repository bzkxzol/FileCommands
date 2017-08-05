import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.concurrent.TimeUnit;

public class Setup {

    protected static File MergeFiles(String fileName1, String fileName2) throws InterruptedException {
        File file1 = new File (fileName1);
        File file2 = new File (fileName2);

        CheckFileExist (file1);
        CheckFileExist (file2);

        File mergedFile = new File ("Merged_" + fileName1.substring (0,fileName1.lastIndexOf (".")) + "_" + fileName2.substring (0,fileName2.lastIndexOf (".")) + ".txt" );

        FromFileToFile (file1, mergedFile);
        FromFileToFile (file2, mergedFile);

        return mergedFile;
    }


    private static void FromFileToFile(File source, File dest) {
        FileReader fr;
        BufferedReader reader;
        FileWriter fw;
        String data;

        try {
            fw = new FileWriter (dest , true);
            fr = new FileReader (source);
            reader = new BufferedReader (fr);
            while (true) {
                data = reader.readLine ();
                if (data != null)
                    fw.write (data + "\n");
                else
                    break;
            }
            fw.close ();
            fr.close ();
            reader.close ();

        } catch (IOException e) {
            e.getMessage ();
        }
    }


    private static void CheckFileExist(File name) throws InterruptedException {
        try{
            if(!name.isFile())
                throw new NoSuchFileException("Файл не найден по указанному пути");
        }catch (NoSuchFileException e){
            System.out.println(e.getMessage());
            TimeUnit.SECONDS.sleep(3);
            System.exit(9);
        }
    }

}
