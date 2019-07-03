import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
class KYC
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int test = Integer.parseInt(br.readLine());
        while(test>0)
        {
            test--;
            String input[] = br.readLine().split(" ");
            Calendar c1=Calendar.getInstance();
            Calendar c2=Calendar.getInstance();
            
            
            int x[]=generateTokenarray(input[0]);

            c1.set(Calendar.DATE,x[0]);
            c1.set(Calendar.MONTH,x[1]-1);
            c1.set(Calendar.YEAR,x[2]);

            int y[]=generateTokenarray(input[1]);
            c2.set(Calendar.DATE,y[0]);
            c2.set(Calendar.MONTH,y[1]-1);
            c2.set(Calendar.YEAR,y[2]);
            Date currDate=c2.getTime();
            
            if(c1.getTime().after(currDate))
            {
                System.out.println("No range");
                continue;
            }
            c1.set(Calendar.YEAR, y[2]);

            c1.add(Calendar.DATE,-30);
            System.out.print(df.format(c1.getTime()));
            c1.add(Calendar.DATE,60);
            
            if(c1.getTime().after(currDate)) System.out.println(" "+df.format(currDate));
            else System.out.println(" "+df.format(c1.getTime()));
        }
    }

    public static int[] generateTokenarray(String s){
        StringTokenizer st = new StringTokenizer(s,"-");
        int x[]= new int[3];
        int i=0;
        while(st.hasMoreTokens())
            x[i++] = Integer.parseInt(st.nextToken());
        return x;
    }
}