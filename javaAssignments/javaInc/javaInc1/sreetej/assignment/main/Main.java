package sreetej.assignment.main;

import sreetej.assignment.data.Data;
import sreetej.assignment.singleton.Single;
public class Main
{
	public static void main(String...args)
	{
        Data data= new Data();
        Single single=Single.getObject("Sreetej reddy");
        data.getInstanceVar();
        single.getName();
	}
}
