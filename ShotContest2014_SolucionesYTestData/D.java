import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class D
{
	static final String NAME = "d";
	static final File _ = new File(NAME+".in");
	public static void main(String[] args)throws Exception
	{
		long begin = System.currentTimeMillis();
		System.setOut( new PrintStream(new File(NAME+".oficial")) );
		BufferedReader br = _.exists()?new BufferedReader( new FileReader(_)) : new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			String ans = makeDancing( str );
			System.out.println(ans);
		}			
		System.setOut( new PrintStream(new File(NAME+".time")) );		
		System.out.println((System.currentTimeMillis()-begin)+" miliseconds of execution of "+NAME);		
	}	
	public static String makeDancing(String sentence) {
		String ret = "";
		boolean upper = true;
		for (int i=0; i<sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c == ' ') {
				ret += " ";
			} else {
				if (upper) {
					ret += Character.toUpperCase(c);
				} else {
					ret += Character.toLowerCase(c);
				}
				upper = !upper;
			}
		}
		return ret;
	}
}
