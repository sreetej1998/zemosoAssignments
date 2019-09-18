import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class Ping
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc= new Scanner(System.in);
        ArrayList<Double> responseTime= new ArrayList<Double>();
   
        System.out.println("enter the number of packets that median needs to be found");
        int numberOfPackets=sc.nextInt();
        System.out.println("enter the link that needs to be pinged");
        String pingLink=sc.next();
        String command = "ping -c"+ numberOfPackets + " " + pingLink;

        
        Runtime run = Runtime.getRuntime();
        Process process = run.exec(command);
        process.waitFor();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String systemUtilPingOutput = "";
        buffer.readLine();

        //parsing the system output and adding ping values to the array
        while ((systemUtilPingOutput=buffer.readLine())!=null) {
            if(systemUtilPingOutput.split(" ").length==9)
            responseTime.add(parsePingOutput(systemUtilPingOutput));
        }

        //calculatng the medium
        Collections.sort(responseTime);
        if(numberOfPackets%2==1)
            System.out.println("Median :"+responseTime.get(numberOfPackets/2)+" ms");
        else{
            double avg=(responseTime.get(numberOfPackets/2) + responseTime.get(numberOfPackets/2 + 1))/2;
            System.out.println("Median :"+avg+" ms");
        }
    }

   
    public static double parsePingOutput(String line)
    {
        String s[]=line.split(" ");
        double responseTime=Double.parseDouble(s[7].substring(5,s[7].length()));
        return responseTime; 

    }
}
