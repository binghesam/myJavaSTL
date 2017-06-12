package nlp;

//supporting package
import java.io.*;
import java.util.*;
import java.math.*;

public class nlp {
	//scanner reader
	public String readFile(String pathName) throws FileNotFoundException{
		Scanner scanner=new Scanner(new File(pathName));
		//scanner.next();
		//debugging
		for(int i=0;i<50;i++){			
			System.out.println(scanner.next());
		}		
		return null;
	}
	//file reader
	public String readFile1(String pathName)throws FileNotFoundException{
		InputStream is=new FileInputStream(pathName);
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		StringBuilder strBuilder=new StringBuilder();
		try{			
			String line=reader.readLine();
			//reader.	
			while(line!=null){
				for(int i=0;i<line.length();i++){
					strBuilder.append(line.charAt(i));
					strBuilder.append(" ");
				}
				strBuilder.append("\n");
				line=reader.readLine();					
			}
			//System.out.println(strBuilder.toString());//for debugging
			
		}catch(Exception e){
			e.printStackTrace();			
		}
		return strBuilder.toString();
	}
	//write file ansi file
	public void writeFile(String pathNameWithFile, String data)throws Exception{
		FileWriter writer=new FileWriter(pathNameWithFile);
		writer.write(data);
	}
	//write file with utf specific file type
	public void writeFile1(String pathNameWithFile, String data)throws Exception{
		try{
			FileOutputStream fos=new FileOutputStream(pathNameWithFile);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			osw.write(data);
			osw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//main function
	public static void main(String args[]) throws Exception{
		String pathName="./src/newsTrain.txt";
		String pathNameWithFile="./src/newsTrainBlank.txt";
		
//		String pathName="./src/newsTest.txt";
//		String pathNameWithFile="./src/newsTestBlank.txt";
		
		nlp a=new nlp();
		//a.readFile1(pathName);
		a.writeFile1(pathNameWithFile, a.readFile1(pathName));
	}
}
