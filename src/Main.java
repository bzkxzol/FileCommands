import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends Setup{

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader (new FileReader ("commands.csv"));
        String line;
        String[] data;
        while (true) {
            line = reader.readLine ();
            if (line == null)
                break;
            data = line.split (",");
            for (int i = 0; i < data.length; i+=3) {
                switch (data[i]) {
                    case "SUM": {
                        double result = Double.parseDouble (data[i + 1]) + Double.parseDouble (data[i + 2]);
                        System.out.println ("Результат операции " + data[i] + ": " + result);
                        break;
                    }
                    case "MULT": {
                        double result = Double.parseDouble (data[i + 1]) * Double.parseDouble (data[i + 2]);
                        System.out.println ("Результат операции " + data[i] + ": " + result);
                        break;
                    }
                    case "DIV": {
                        double result = Double.parseDouble (data[i + 1]) / Double.parseDouble (data[i + 2]);
                        System.out.println ("Результат операции " + data[i] + ": " + result);
                        break;
                    }
                    case "SUB": {
                        double result = Double.parseDouble (data[i + 1]) - Double.parseDouble (data[i + 2]);
                        System.out.println ("Результат операции " + data[i] + ": " + result);
                        break;
                    }
                    case "CONT": {
                        String result = String.join (" " , data[i + 1] , data[i + 2]);
                        System.out.println ("Результат операции " + data[i] + ": " + result);
                        break;
                    }
                    case "MERGE": {
                        System.out.println("Результат операции " + data[i] + ": " + MergeFiles (data[i+1], data[i+2]).getName ());
                        break;
                    }
                    default:
                        System.out.println("Ошибка/Команда не найдена - " + data[i]);
                        break;
                }
            }
        }
    }
}
