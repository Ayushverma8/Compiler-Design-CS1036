import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class LexicalAnal {
    public static void main(String[] args) throws Exception {
        int x = 100;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("D:\\hello.txt");
            bufferedReader = new BufferedReader(fileReader);
            StreamTokenizer st = new StreamTokenizer(bufferedReader);
            boolean eof = false;
            String[] keys={"auto","break","case","char","const","continue","default",
                    "do","double","else","enum","extern","float","for","goto",
                    "if","int","long","register","return","short","signed",
                    "sizeof","static","struct","switch","typedef","union",
                    "printf",
                    "unsigned","void","volatile","while","class","public","main","String","System.out.println"};
            char[] oper={
                    '!','%','^','&','*','-','+','=','~','|','.','<','>','/','?'
            };
            do {
                int token = st.nextToken();
                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println("End of File encountered");
                     
                        eof = true;
                        break;
                    case StreamTokenizer.TT_WORD:
                        int count=0;
                        for(int i=0;i<keys.length;i++){
                            if(keys[i].equals(st.sval)){
                                System.out.println(st.sval+" is a keyword");
                               
                                count++;
                                break;
                            }
                        }
                        if(count==0){
                        	
                            ArrayList<String> list = new ArrayList<>();
                            list.add(st.sval);
                           
                            System.out.println(st.sval+" is an indentifier");
                           
                           
                            System.out.println(list+"  position: "+x++);
                        }
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Number: " + st.nval);

                        break;
                    default:
                        int counter=0;
                        for(int i=0;i<oper.length;i++){
                            if(((char) token)==oper[i] ){
                                System.out.println((char) token +" is an operatior");
                            
                                counter++;
                                break;
                            }
                        }
                        if(counter==0){
                            System.out.println((char)token +" is encountered");
                            
                        }
                        
                    
                }
            } while (!eof);
        } catch (Exception e) {
            System.out.print("");
        }
        
    }
}
