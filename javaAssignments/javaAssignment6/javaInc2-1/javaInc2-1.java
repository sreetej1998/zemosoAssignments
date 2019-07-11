
import java.util.*;
class Vampire
{
	public static void main(String[] args) {
        int count=0;
        int f=0;
		for(int i=1260;count!=100;i++){
			if(Integer.toString(i).length()%2==0){
            f=checkVampire(i);
            if(f==1)
            count++;}
		}
	}
	
	public static int genNum(int length){
	    String a="1";
	    while(a.length()!=length)
	    a=a+"0";
	    return Integer.parseInt(a);
	}

	public static HashMap insertMap(String name){
	    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	   for(char a:name.toCharArray()){
	       if(map.containsKey(a)) map.put(a,map.get(a)+1);
	       else map.put(a,1);
	   } 
	   return map;
	}

	public static boolean equate(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
	    if(map1.size()!=map2.size()) return false;
	    for(Map.Entry m:map1.entrySet()){
	        if(map2.get(m.getKey())!=m.getValue()) return false;
	    }
	    return true;
	}
	
	public static int  getFinal(int length){
	    String a="9";
	    while(a.length()!=length)
	    a=a+"9";
	    return Integer.parseInt(a);
    }
    
    public static int checkVampire(int num){
        HashMap<Character,Integer> map;
		String numString=Integer.toString(num);
		map=insertMap(numString);
		int length=numString.length()/2;
		int initialNum=genNum(length);
		int finalNum=getFinal(length);

		//checking with possible integers as factors
		for(int i=initialNum;i<=finalNum;i++){
			int flag=0;
		    HashMap<Character,Integer> testMap;
		    if(num%i==0 && Integer.toString(num/i).length()==length ){
		        int factorA=i;
				int factorB=num/i;
				String total=Integer.toString(factorA)+Integer.toString(factorB);
				testMap=insertMap(total);
				
				if(equate(testMap,map)){
					System.out.println(num+"  "+factorA+ " "+factorB);
					return 1;	
				}
			}
	}
	return 0;
}
}
