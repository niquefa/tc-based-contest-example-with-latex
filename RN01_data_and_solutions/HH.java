import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HH
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str = br.readLine()) != null )
		{
			String ans = makeDancing( str );
			System.out.println(ans);
		}			
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
