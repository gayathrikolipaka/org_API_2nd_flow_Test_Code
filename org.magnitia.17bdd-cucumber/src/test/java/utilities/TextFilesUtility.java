package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextFilesUtility
{
	//There is a chance of multiple text files with test data in our project
	//Access existing text file or CSV file, which consists of test data
	public static String[] getValuesOfLine(String filepath,int linenumber) throws Exception
	{
		File f=new File(filepath); //locate file n HDD
		FileReader fr=new FileReader(f); //take READ permission
		BufferedReader br=new BufferedReader(fr); //shift to RAM
		try
		{
			//move to a line which is before the target line
			for(int i=1;i<linenumber;i++)
			{
				br.readLine();
			}
			//get target line & split into values by seperating with ,
			String temp=br.readLine();
			String output[]=temp.split(",");
			br.close(); //back to HDD
			fr.close(); //Close READ permission
			return(output);
		}
		catch(Exception ex)
		{ 
			RuntimeException obj=new RuntimeException("Wrong line number");
			throw obj; 
		}
	}
}








