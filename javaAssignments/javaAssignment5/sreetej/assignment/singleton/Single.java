package sreetej.assignment.singleton;
public class Single
{
	String name;
	public static Single getObject(String str)
	{
        Single single=new Single();
		single.name=str;	
        return single;
	}
    public void getName()
    {
        System.out.println("Name is :"+name);
    }
}
