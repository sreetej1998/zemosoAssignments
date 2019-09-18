
//the space complexity is O(1) as no varible is dependent on input
//the time complexity id O(n)

import java.util.Scanner;

class CheckAlphabets
{
    public static void main(String args[])
    {

        Scanner sc= new Scanner(System.in);
        boolean hasAlphabet[]= new boolean[26];
        String name=sc.next();
        boolean checkAlphabets=true;


        for(char i:name.toCharArray()){
            int lowerCase=i-'a';
            int upperCase=i-'A';
            if(lowerCase>=0 && lowerCase<26) hasAlphabet[lowerCase]=true;
            else if(upperCase>=0 && upperCase<26) hasAlphabet[upperCase]=true;
        }
        for(boolean alphabet:hasAlphabet){
            if(!alphabet){
                System.out.println("false");
                checkAlphabets=false;
                break;
            }
        }
        if(checkAlphabets) System.out.println("true");

    }
}
