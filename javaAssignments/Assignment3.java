import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
//to run this type eg( java Ping 11 google.com )
class Ping
{
    public static void main(String args[]) throws Exception
    {
        //array for storing ping values
        ArrayList<Double> arr= new ArrayList<Double>();
        //this allows user to type number of packets the want to test on
        int numberOfPac=Integer.parseInt(args[0]);
        //this link gets pinged
        String pingLink=args[1];
        String cmd = "ping -c"+ numberOfPac + " " + pingLink;

        //running system ping system utility
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        buf.readLine();

        //parsing the system output and adding ping values
        while ((line=buf.readLine())!=null) {
            if(line.split(" ").length==9)
            arr.add(parseNum(line));
        }

        //calculatng the medium
        Collections.sort(arr);
        if(numberOfPac%2==1)
            System.out.println("Median :"+arr.get(numberOfPac/2)+" ms");
        else{
            double avg=(arr.get(numberOfPac/2) + arr.get(numberOfPac/2 + 1))/2;
            System.out.println("Median :"+avg+" ms");
        }
    }

    // takes line and returns the number after parsing
    public static double parseNum(String line)
    {
        String s[]=line.split(" ");
        double num=Double.parseDouble(s[7].substring(5,s[7].length()));
        return num; 

    }
}