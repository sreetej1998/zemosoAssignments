import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
class KYC
{
    public static void main(String args[])throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        int test = Integer.parseInt(buffer.readLine());
        while(test>0){
            test--;
            String input[] = buffer.readLine().split(" ");
            Calendar applyTime=Calendar.getInstance();
            Calendar currentTime=Calendar.getInstance();
            
            
            int applicationDate[]=generateTokenarray(input[0]);

            applyTime.set(Calendar.DATE,applicationDate[0]);
            applyTime.set(Calendar.MONTH,applicationDate[1]-1);
            applyTime.set(Calendar.YEAR,applicationDate[2]);

            int currentDate[]=generateTokenarray(input[1]);
            currentTime.set(Calendar.DATE,currentDate[0]);
            currentTime.set(Calendar.MONTH,currentDate[1]-1);
            currentTime.set(Calendar.YEAR,currentDate[2]);

            
            if(applyTime.getTime().after(currentTime.getTime())){
                System.out.println("No range");
                continue;
            }
            applyTime.set(Calendar.YEAR, currentDate[2]);

            applyTime.add(Calendar.DATE,-30);
            System.out.print(dateFormat.format(applyTime.getTime()));
            applyTime.add(Calendar.DATE,60);
            
            if(applyTime.getTime().after(currentTime.getTime())) System.out.println(" "+dateFormat.format(currentTime.getTime()));
            else System.out.println(" "+dateFormat.format(applyTime.getTime()));
        }
    }

    public static int[] generateTokenarray(String s){
        StringTokenizer tokenizer = new StringTokenizer(s,"-");
        int dateTokens[]= new int[3];
        int tokenIndex=0;
        while(tokenizer.hasMoreTokens())
            dateTokens[tokenIndex++] = Integer.parseInt(tokenizer.nextToken());
        return dateTokens;
        
    }
}
