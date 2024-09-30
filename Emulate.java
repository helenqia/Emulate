//Usage: java WordGen <k> < <input.txt>
import java.util.Scanner;
public class Emulate {
    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Not valid input");
            return;
        }
        Scanner in = new Scanner(System.in);
        StringBuffer textBuffer = new StringBuffer();
        String str = scannerHelper(in, textBuffer);
        int k = Integer.parseInt(args[0]);
        int length = 1500;
        if(k > str.length() - k || k > length - k || k < 0){
            System.out.println("Your k value is not a valid k value");
            return;
        }
        Table table = new Table();
        String word = "";
        for(int i = 0; i < k; i++){
            str += str.charAt(i);
        }
        for(int i = 0; i < str.length()-k; i++){
            word = str.substring(i, k + i);
            table.add(word, str.charAt(k + i));
        }
        System.out.println(createPara(length - k, table, str.substring(0,k)));
    }
    /**
     * Helper method which creates a string from text
     * @param in Scanner 
     * @param textBuffer StringBuffer
     * @return a string which holds a string of the ytext on the file
     */
    public static String scannerHelper(Scanner in, StringBuffer textBuffer){
             while (in.hasNextLine()) {
            String line = in.nextLine();
            textBuffer.append(line);
            textBuffer.append("\n");
        }
        return textBuffer.toString();
    }
    /**
     * createPara method creates a paragraph from a table 
     * @param length length of paragraph
     * @param table table of prefix connected to frequency table of possible suffixes
     * @param begin character to start string on
     * @return a string of the created paragraph
     */
    public static String createPara(int length, Table table, String begin){
        System.out.println(begin);
        String str = new String(begin);
        String chunk = new String(begin);
        while(length !=0){
            char next = table.choose(chunk);
            str += next;
            if(begin.equals("")){
                chunk = "";
            }
            else{
                chunk = chunk.substring(1,chunk.length()) + next;
            }
            length--; 
        }
        return str;
    }
}

