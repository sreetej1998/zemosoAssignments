import java.util.*;
import java.util.regex.*;
class Reg{
    public static void main(String args[]){
        String regex="^[A-Z].*\\.";
        String line=args[0];
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(line);
        if(m.find()) System.out.println("found");
        else System.out.println("not found");
    }
}