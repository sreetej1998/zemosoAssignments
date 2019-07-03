import java.util.*;
//the space complexity is O(1) as no varible is dependent on input
//the time complexity id O(n)
//to run this eg:java CheckAlpha "string to check"
class CheckAlpha
{
    public static void main(String args[])
    {
        //array for storing alphabets(both lowercase and uppercase)
        boolean arr[]= new boolean[26];
        String name=args[0];
        int flag=0;

        //iterating each character and filling the boolean array
        for(char i:name.toCharArray()){
            int lowerCase=i-'a';
            int upperCase=i-'A';
            if(lowerCase>=0 && lowerCase<=26) arr[lowerCase]=true;
            else if(upperCase>=0 && upperCase<=26) arr[upperCase]=true;
        }

        for(boolean i:arr){
            if(!i){
                System.out.println("false");
                flag=1;
                break;
            }
        }
        if(flag==0) System.out.println("true");

    }
}