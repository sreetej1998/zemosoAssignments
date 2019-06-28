import java.io.*;
import java.util.*;
import java.util.regex.*;
//first arg is the regular expresion
//second is the directory that the search needs to happen 
//to run this file eg:java Path_finder "Path_finder.java"  "/home"
class Path_finder
{
    public static StringBuilder sb= new StringBuilder("");
    public static void main(String args[]) throws IOException
    {
        
        String regex=args[0];
        String directory=args[1];
        Pattern pa=Pattern.compile(regex);
        Path_finder p= new Path_finder();

        // find_files stores absolute paths in the stringbuilder object
        p.find_files(directory,pa,p.sb);

        //invokes the overridden toString method
        System.out.println(p);

    }
  
    public void find_files(String main_f,Pattern pa,StringBuilder sb)
    {
        //recursively finding files with matching regular expression
         File current_dir=new File(main_f);
         for(File i:current_dir.listFiles())
         {
             Matcher m=pa.matcher(i.getName());
             if(i.isDirectory()) find_files(i.getAbsolutePath(),pa,sb);
             else if(i.isFile() && m.matches())
             {
            sb.append(i.getAbsolutePath());
            sb.append("\n");
            }
         }    
    }
    //overriding the toString() method for printing files when the object is printed
    public String toString()
    {
        return sb.toString();
    }

}