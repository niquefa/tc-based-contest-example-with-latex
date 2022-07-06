import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class EE {
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			int N = Integer.parseInt(str.trim());
			String a[] = new String[N];
			for (int i = 0; i < N; i++)
				a[i] = br.readLine();
			String ans[] = convert(a);
			for (int i = 0; i < ans.length; i++) {
				System.out.println(ans[i]);
			}
		}			
	}	
	static String[] convert(String[] program) {
		for (int x=0; x<program.length; x++) {
			String s = program[x];
			String ss = "";
			if (s.indexOf("//") != -1) {
				ss = s.substring(s.indexOf("//"));
				s = s.substring(0, s.indexOf("//"));
			}
			while (s.indexOf("->") != -1)
				s = s.replaceAll("->",".");
			program[x] = s + ss;
		}
		return program;
	} 
}
